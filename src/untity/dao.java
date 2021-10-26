package untity;

import entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class dao {

    public  List<Map<String, String>> getStatistical(int pageNum, int pageSize, String payerCode, String payerName) {
        boolean checkCode = payerCode!=null&&payerCode.toString().length()>0;
        boolean checkName = payerName!=null&&payerName.toString().length()>0;
        String sql = "select * from tb_tax_payer p LEFT join tb_tax_source s on p.id=s.payerId JOIN tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id  where s.id is null and p.removeState=0 ";
        if(checkCode){
            sql=sql+"and p.payerCode = "+payerCode;
        }
        if(checkName){
            sql=sql+" and payerName like '%"+payerName+"%' ";
        }
        sql=sql+" limit ?,?";
        List<Map<String, String>> list = DBUtil.query(sql, (pageNum-1)*pageSize,pageSize);
        return list;

    }

    public Taxer selectTaxerById(Integer userId) {
        Taxer tx=new Taxer();

        String sql="SELECT * FROM tb_taxer WHERE id=?";
        List<Map<String, String>> query = DBUtil.query(sql, userId);

        for (Map<String,String> map: query) {
            BeanUtil.mapToBean(tx,map);
        }

        return tx;
    }


    public List<TaxOrgan> selectAllshuiwuju() {
        List<TaxOrgan> li=new ArrayList<>();
       String sql ="select *from tb_tax_organ";
        List<Map<String, String>> query = DBUtil.query(sql);


        for (Map<String,String> map: query) {
            TaxOrgan tx=new TaxOrgan();
            BeanUtil .mapToBean(tx,map);

            li.add(tx);
        }


        return li;
    }

    public List<Industr> selectAllhangye() {

        List<Industr> li=new ArrayList<>();
        String sql ="select *from tb_industry";
        List<Map<String, String>> query = DBUtil.query(sql);


        for (Map<String,String> map: query) {
            Industr in=new Industr();
            BeanUtil .mapToBean(in,map);
            li.add(in);
        }


        return li;
    }

    public List<TaxPayer> selectSerch(String payerCode,String payerName,int page,int row) {
        List<TaxPayer> li=new ArrayList<TaxPayer>();
        if(!payerCode.equals("")){
            String sql="SELECT * from tb_tax_payer  a,tb_industry  b,tb_tax_organ  c where a.industryId = b.id and a.taxOrganId = c.id and a.removeState=0 and a.payerCode=? ";
            int payerCode1=Integer.parseInt(payerCode);

            List<Map<String, String>> query = DBUtil.query(sql,payerCode1);
            for (Map<String,String> map: query){
                TaxPayer tx=new TaxPayer();
                BeanUtil.mapToBean(tx,map);
                li.add(tx);
            }
        }else {
            String sql="SELECT * from tb_tax_payer  a,tb_industry  b,tb_tax_organ  c where a.industryId = b.id and a.taxOrganId = c.id AND a.payerName like ? LIMIT ?,?";
            String payername="%"+payerName+"%";

            List<Map<String, String>> query = DBUtil.query(sql, payername, page-1, row);
//            System.out.println(payerName);
            for (Map<String,String> map: query){
                TaxPayer tx=new TaxPayer();
                BeanUtil.mapToBean(tx,map);
                li.add(tx);
            }

        }

        return li;
    }

    public List<Taxer> selectAllTaxer() {
        List<Taxer> li =new ArrayList<>();
        String sql ="select *from tb_taxer";
        List<Map<String, String>> query = DBUtil.query(sql);


        for (Map<String,String> map: query) {
            Taxer tx=new Taxer();
            BeanUtil .mapToBean(tx,map);
            li.add(tx);
        }

        return li;
    }


    public List<TaxSource> selectSourceBypage(int page, int rows) {
        List<TaxSource> lit=new ArrayList<>();
        String sql="SELECT a.*,b.payerCode,b.payerName,b.bizScope,c.organName,d.industryName,timestampdiff(day,executeTime,recordTaskDate) as timeOut from tb_tax_source as a,tb_tax_payer as b,tb_tax_organ as c,tb_industry AS d where a.payerId = b.id and a.subOrganId = c.id AND d.id =b.industryId  AND a.removeState=0 LIMIT ?,?; ";
        List<Map<String, String>> query = DBUtil.query(sql, page, rows);
        for (Map<String,String> map:query){
            TaxSource tx=new TaxSource();
            BeanUtil.mapToBean(tx,map);
            lit.add(tx);
        }
        return  lit;

    }

    public TaxPayer selectPayerById(int id) {
        TaxPayer tx=new TaxPayer();
        String sql="SELECT * FROM tb_tax_payer WHERE id=? ";
        List<Map<String, String>> query = DBUtil.query(sql,id);
        for (Map<String, String> map:query){
            BeanUtil.mapToBean(tx,map);
        }

        return tx;
    }

    public User selectUserByName(String xiaozhang) {
        User us=new User();
        String sql="SELECT * FROM tb_user WHERE username= ?";
        List<Map<String, String>> query = DBUtil.query(sql, xiaozhang);
        for (Map<String, String> map:query){
            BeanUtil.mapToBean(us,map);
        }

        return us;
    }

    public TaxSource selectSourceById(int id) {
        TaxSource tx=new TaxSource();
        String sql="SELECT a.*,b.payerCode,b.payerName,b.bizScope,c.organName,d.industryName from tb_tax_source as a,tb_tax_payer as b,tb_tax_organ as c,tb_industry AS d where a.payerId = b.id and a.subOrganId = c.id AND d.id =b.industryId AND a.id=?";
        List<Map<String, String>> query = DBUtil.query(sql, id);
        for (Map<String, String> map:query){
            BeanUtil.mapToBean(tx,map);
        }



        return tx;

    }

    public User selectUserById(Integer UserId) {
        User us=new User();

        String sql="SELECT * FROM tb_user WHERE id=?";
        List<Map<String, String>> query = DBUtil.query(sql, UserId);
        for (Map<String, String> map:query){
            BeanUtil.mapToBean(us,map);
        }

        return us;
    }

    public int addTask(TaxSource task ,String table) {
        int a=0;
        a = DBUtil.add(task, table);

        return a;
    }

    public List<Map<String, String>> getSearchResult(int pageNum, int pageSize, String taxerName) {
        boolean checkName = taxerName!=null&&taxerName.toString().length()>0;
        String sql = "select * from tb_taxer where state=0 ";
        if(checkName){
            sql=sql+" and taxerName like '%"+taxerName+"%' ";
        }
        sql=sql+" limit ?,?";
        List<Map<String, String>> list = DBUtil.query(sql, (pageNum-1)*pageSize,pageSize);
        return list;
    }

    public int getSearchRows(String taxerName) {
        boolean checkName = taxerName!=null&&taxerName.toString().length()>0;
        String sql = "select * from tb_taxer  where 1=1 ";
        if(checkName){
            sql=sql+" and taxerName like '%"+taxerName+"%' ";
        }
        List<Map<String, String>> list = DBUtil.query(sql);
        return list.size();
    }

    public boolean update(String username, String oldPassword, String newPassword) {

        User us=new User();
        List< Map<String, String>> query= DBUtil.query("select * from tb_user where username = ?", username);
        for (Map<String, String> map:query){
            BeanUtil.mapToBean(us,map);
        }
        String password = us.getPassword();
        if(!password.equals(oldPassword)){
            return false;
        }


        boolean row = DBUtil.update("update tb_user set password=? where username =?", newPassword,username);


        return row;
    }

    public TaxOrgan selectOrganById(Integer organId) {
        TaxOrgan tx=new TaxOrgan();
        String sql="SELECT * FROM tb_tax_organ WHERE id=?";
        List<Map<String, String>> query = DBUtil.query(sql, organId);
        for (Map<String, String> map:query){
            BeanUtil.mapToBean(tx,map);
        }
        return tx;
    }

    public boolean updateTaxer(Taxer taxer, int id) {
        int rows = DBUtil.edit(taxer, "tb_taxer", id);
        return rows==1;
    }

    public boolean addTaxer(Taxer taxer) {
        int row = DBUtil.add(taxer,"tb_taxer");
        return row==1;
    }
}
