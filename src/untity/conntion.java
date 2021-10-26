package untity;

import entity.TaxPayer;
import entity.TaxSource;
import entity.Taxer;
import entity.messmge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class conntion {
    private static Connection conn;

    public conntion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shuiyuan",
                    "root",
                    "xiaozhang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int lianjie(String name,String mima){
        int a=0;
        try {
            String sql="select *from tb_user where username=? and password=?";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1,name);
            prs.setString(2,mima);
            ResultSet rs = prs.executeQuery();
            if(rs.next()){
                a= rs.getInt("permissionId");
                return a;
            }else {
                return a;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }






    public List selectPage(int page,int size){

        List li=new ArrayList<>();

        try {
            String sql="SELECT * from \n" +
                    "tb_tax_payer  a,tb_industry  b,tb_tax_organ  c where a.industryId = b.id and a.taxOrganId = c.id and a.removeState=0 limit ?,?;";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setInt(1,(page-1)*size);
            prs.setInt(2,size);
            ResultSet rs = prs.executeQuery();

            while (rs.next()){
                TaxPayer tx=new TaxPayer();
                tx.setId(rs.getInt("id"));
                tx.setPayerCode(rs.getString("payerCode"));
                tx.setPayerName(rs.getString("payerName"));
                tx.setOrganName(rs.getString("organName"));
                tx.setIndustryName(rs.getString("industryName"));
                tx.setLegalPerson(rs.getString("legalPerson"));
                tx.setLegalIdCard(rs.getString("legalidcard"));
                tx.setFinaceName(rs.getString("finaceName"));
                tx.setFinaceIdCard(rs.getString("finaceidCard"));
                tx.setRecordDate(rs.getString("recordDate"));
//                tx.setTaxOrganId(Integer.valueOf(rs.getString("organName")));

                li.add(tx);
            }
//            return li;

        }catch (Exception e){}
        return li;
    }

    public int selectcount(){
        int i=0;
        try {
            String sql="select count(id) from tb_tax_payer where removeState=0";
            PreparedStatement prs = conn.prepareStatement(sql);
            ResultSet rs = prs.executeQuery();
            while (rs.next()){
                i=rs.getInt(1);
            }



            return i;
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }


    public TaxPayer selectTaxPayer(int id) {
        TaxPayer tx=new TaxPayer();
        try {
            String sql="SELECT a.*,a.recordDate,b.industryName,c.organName from \n" +
                    "tb_tax_payer as a,tb_industry as b,tb_tax_organ as c where a.industryId = b.id and a.taxOrganId = c.id and a.id=?;";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setInt(1,id);

            ResultSet rs = prs.executeQuery();
            while (rs.next()){
            tx.setId(rs.getInt("id"));
            tx.setUserId(rs.getInt("userId"));
            tx.setPayerCode(rs.getString("payerCode"));
            tx.setPayerName(rs.getString("payerName"));
            tx.setIndustryId(rs.getInt("industryId"));
            tx.setTaxOrganId(rs.getInt("taxOrganId"));
            tx.setBizAddress(rs.getString("bizAddress"));
            tx.setLegalMobile(rs.getString("legalMobile"));
            tx.setOrganName(rs.getString("organName"));
            tx.setIndustryName(rs.getString("industryName"));
            tx.setBizScope(rs.getString("bizScope"));
            tx.setInvoiceType(rs.getString("invoiceType"));
            tx.setLegalPerson(rs.getString("legalPerson"));
            tx.setLegalIdCard(rs.getString("legalIdCard"));
            tx.setFinaceName(rs.getString("finaceName"));
            tx.setFinaceIdCard(rs.getString("finaceIdCard"));
            tx.setRecordDate(rs.getString("recordDate"));


            }


        }catch (Exception e){
            e.printStackTrace();
        }



        return tx;
    }



    public int delectTaxPayer(int id) {
        int a=0;
        try {
            String sql="update tb_tax_payer set removeState= 1 where id = ?";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setInt(1,id);
            a = prs.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }


        return a;
    }


    public int updateTaxPayer(int id, String payerCode, String payerName, String bizAddress, String legalMobile, int taxOrganId, int industryId, String bizScope, String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard) {
         int a=0;
       String sql="UPDATE tb_tax_payer SET payerCode=?,payerName=?,bizAddress=?,legalMobile=?,taxOrganId=?,industryId=?,bizScope=?,invoiceType=?,legalPerson=?,legalIdCard=?,finaceName=?,finaceIdCard=? WHERE id=?";
      try {
          PreparedStatement prs = conn.prepareStatement(sql);
          prs.setString(1,payerCode);
          prs.setString(2,payerName);
          prs.setString(3,bizAddress);
          prs.setString(4,legalMobile);
          prs.setInt(5,taxOrganId);
          prs.setInt(6,industryId);
          prs.setString(7,bizScope);
          prs.setString(8,invoiceType);
          prs.setString(9,legalPerson);
          prs.setString(10,legalIdCard);
          prs.setString(11,finaceName);
          prs.setString(12,finaceIdCard);
          prs.setInt(13,id);

          a=prs.executeUpdate();
      }catch (Exception e){
          e.printStackTrace();
      }

        return a;
    }

    public int countBypayerName(String payerName) {
        int i=0;
        try {
            String sql="select count(id) from tb_tax_payer where payerName like ?";
            PreparedStatement prs = conn.prepareStatement(sql);
            String payername="%"+payerName+"%";
            prs.setString(1,payerName);
            ResultSet rs = prs.executeQuery();
            while (rs.next()){
                i=rs.getInt(1);
            }

            return i;
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;

    }

    public boolean addtaxpayer(TaxPayer payer) {
        boolean a=false;
        try {
            String sql = "insert into tb_tax_payer(payerCode,payerName,bizAddress,bizAddressPhone,taxOrganId,industryId,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,userId,recordDate) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,payer.getPayerCode());
            ps.setString(2,payer.getPayerName());
            ps.setString(3,payer.getBizAddress());
            ps.setString(4,payer.getBizAddressPhone());
            ps.setInt(5,payer.getTaxOrganId());
            ps.setInt(6,payer.getIndustryId());
            ps.setString(7,payer.getBizScope());
            ps.setString(8,payer.getInvoiceType());
            ps.setString(9,payer.getLegalPerson());
            ps.setString(10,payer.getLegalIdCard());
            ps.setString(11,payer.getFinaceName());
            ps.setString(12,payer.getFinaceIdCard());
            ps.setInt(13,payer.getUserId());
            ps.setString(14,payer.getRecordDate());
            int i = ps.executeUpdate();
            if (i!=0){
                a=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return a;
    }

    public int addTask(TaxSource source) {
        int a=0;
        try {
            String sql = "insert into tb_tax_source(payerId,taskName,subOrganId,approverId,executeId,executeTime,recordTaskDate,taskState,recordUserId) value(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, source.getPayerId());
            ps.setString(2, source.getTaskName());
            ps.setInt(3, source.getSubOrganId());
            ps.setInt(4, source.getApproverId());
            ps.setInt(5, source.getExecuteId());
            ps.setString(6, source.getExecuteTime());
            ps.setString(7,source.getRecordTaskDate());
            ps.setString(8, source.getTaskState());
            ps.setInt(9,source.getRecordUserId());
            a = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return a;

    }

    public TaxPayer selectTaxPayerBypayeCode(int payerCode) {
        TaxPayer tx=new TaxPayer();
        try {
            String sql="SELECT a.*,a.recordDate,b.industryName,c.organName from tb_tax_payer as a,tb_industry as b,tb_tax_organ as c where a.industryId = b.id and a.taxOrganId = c.id and a.payerCode=?;";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setInt(1,payerCode);

            ResultSet rs = prs.executeQuery();
            while (rs.next()){
                tx.setId(rs.getInt("id"));
                tx.setUserId(rs.getInt("userId"));
                tx.setPayerCode(rs.getString("payerCode"));
                tx.setPayerName(rs.getString("payerName"));
                tx.setIndustryId(rs.getInt("industryId"));
                tx.setTaxOrganId(rs.getInt("taxOrganId"));
                tx.setBizAddress(rs.getString("bizAddress"));
                tx.setLegalMobile(rs.getString("legalMobile"));
                tx.setOrganName(rs.getString("organName"));
                tx.setIndustryName(rs.getString("industryName"));
                tx.setBizScope(rs.getString("bizScope"));
                tx.setInvoiceType(rs.getString("invoiceType"));
                tx.setLegalPerson(rs.getString("legalPerson"));
                tx.setLegalIdCard(rs.getString("legalIdCard"));
                tx.setFinaceName(rs.getString("finaceName"));
                tx.setFinaceIdCard(rs.getString("finaceIdCard"));
                tx.setRecordDate(rs.getString("recordDate"));


            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return tx;
    }

    public int countTask() {
        int i=0;
        try {
            String sql="select count(id) from tb_tax_source where removeState=0";
            PreparedStatement prs = conn.prepareStatement(sql);
            ResultSet rs = prs.executeQuery();
            while (rs.next()){
                i=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }


    public int delectSourceById(int id) {
        int a=0;
        try {
            String sql="update tb_tax_source set removeState= 1 where id = ?";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setInt(1,id);
            a = prs.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public int changeTask(TaxSource task) {
        int a=0;
        try {
            String sql="UPDATE tb_tax_source SET subOrganId=?,approverId=?, executeId=?,executeTime=?,taskState=?WHERE id=?";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setInt(1,task.getSubOrganId());
            prs.setInt(2,task.getApproverId());
            prs.setInt(3,task.getExecuteId());
            prs.setString(4,task.getExecuteTime());
            prs.setString(5,task.getTaskState());
            prs.setInt(6,task.getId());
            a = prs.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }

        return a;
    }

    public int getTotalRows() {
        return Integer.parseInt(DBUtil.query("select count(*) c from tb_tax_payer p JOIN tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id ").get(0).get("c"));
    }

    public int delectTaxer(int id) {
        int a=0;
        try {
            String sql="update tb_taxer set state= 1 where id = ?";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setInt(1,id);
            a = prs.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;

    }
}
