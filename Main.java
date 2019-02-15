/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasi;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PATRICK
 */
public class Main extends javax.swing.JFrame {
    private DefaultTableModel model, model2, model3, model4, model5;

    /**
     * Creates new form petugas
     */
    public Main() {
        initComponents();
        model = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        model2 = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        model3 = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        model4 = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        model5 = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        jTable1.setModel(model);
        model.addColumn("ID Petugas");
        model.addColumn("Nama Petugas");
        model.addColumn("Alamat");
        model.addColumn("No Telp.");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tgl. Lahir");
        model.addColumn("Keterangan");
        
        tampildatapetugas();
        
        jTable3.setModel(model2);
        model2.addColumn("ID Anggota");
        model2.addColumn("Nama");
        model2.addColumn("Alamat");
        model2.addColumn("Tgl. Lahir");
        model2.addColumn("Tempat Lahir");
        model2.addColumn("Jenis Kelamin");
        model2.addColumn("No. Telp.");
        model2.addColumn("Status Keanggotaan");
        model2.addColumn("Keterangan");
        
        tampildataanggota();
        
        jTable4.setModel(model3);
        model3.addColumn("Id Pinjaman");
        model3.addColumn("Kategori Pinjaman");
        model3.addColumn("Anggota");
        model3.addColumn("Besar Pinjaman");
        model3.addColumn("Tanggal Pengajuan");
        
        tampildatapinjaman();
        
        jTable5.setModel(model4);
        model4.addColumn("Id Simpanan");
        model4.addColumn("Nama Simpanan");
        model4.addColumn("Anggota");
        model4.addColumn("Tanggal Simpan");
        model4.addColumn("Besar Simpan");
        model4.addColumn("Besar Keterangan");
        
        tampildatasimpanan();
        
        jTable6.setModel(model5);
        model5.addColumn("Id Pinjaman");
        model5.addColumn("Kategori Pinjaman");
        model5.addColumn("Anggota");
        model5.addColumn("Besar Pinjaman");
        model5.addColumn("Tanggal Peminjaman");
        
        tampildatapinjamanangsur();
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we)
            { 
              String ObjButtons[] = {"Ya","Tidak"};
              int PromptResult = JOptionPane.showOptionDialog(null, 
                  "Anda Yakin Ingin Menutup Aplikasi ?", "Pesan", 
                  JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
                  ObjButtons,ObjButtons[1]);
              if(PromptResult==0)
              {
                System.exit(0);          
              }
            }
          });
    }
    
//    method petugas

    void tampildatapetugas (){
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_petugas";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[7];
                o[0]=r.getString("id_petugas");
                o[1]=r.getString("Nama_petugas");
                o[2]=r.getString("Alamat_petugas");
                o[3]=r.getString("No_telp_petugas");
                o[4]=r.getString("Tempat_lahir_petugas");
                o[5]=r.getString("tgl_lahir_petugas");
                o[6]=r.getString("ket_petugas");
                model.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    void tampildatapetugasaktif (){
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_petugas WHERE ket_petugas = 'Aktif'";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[7];
                o[0]=r.getString("id_petugas");
                o[1]=r.getString("Nama_petugas");
                o[2]=r.getString("Alamat_petugas");
                o[3]=r.getString("No_telp_petugas");
                o[4]=r.getString("Tempat_lahir_petugas");
                o[5]=r.getString("tgl_lahir_petugas");
                o[6]=r.getString("ket_petugas");
                model.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    void tampildatapetugasnonaktif (){
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_petugas WHERE ket_petugas = 'Nonaktif'";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[7];
                o[0]=r.getString("id_petugas");
                o[1]=r.getString("Nama_petugas");
                o[2]=r.getString("Alamat_petugas");
                o[3]=r.getString("No_telp_petugas");
                o[4]=r.getString("Tempat_lahir_petugas");
                o[5]=r.getString("tgl_lahir_petugas");
                o[6]=r.getString("ket_petugas");
                model.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    void tablepetugassearch(){
        
            DefaultTableModel tabelTampil1 = new DefaultTableModel();
            tabelTampil1.addColumn("ID Petugas");
            tabelTampil1.addColumn("Nama Petugas");
            tabelTampil1.addColumn("Alamat");
            tabelTampil1.addColumn("No Telp.");
            tabelTampil1.addColumn("Tempat Lahir");
            tabelTampil1.addColumn("Tgl. Lahir");
            tabelTampil1.addColumn("Keterangan");
        try{
             Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql = "Select * from tb_petugas where id_petugas like '%" + jTextField1.getText() + "%'" 
                         + "or Nama_petugas like '%" + jTextField1.getText() + "%'"
                    + "or Alamat_petugas like '%" + jTextField1.getText() + "%'"
                 +   "or No_telp_petugas like '%" + jTextField1.getText() + "%'"
                    +   "or Tempat_lahir_petugas like '%" + jTextField1.getText() + "%'"
                    + "or tgl_lahir_petugas like '%" + jTextField1.getText() + "%'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            tabelTampil1.addRow(new Object[]{
            rs.getString(7),
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            });
            }
          jTable1.setModel(tabelTampil1);

                }catch (Exception e){
                    System.out.println(e);
            }
    }
    
//    method anggota
    void tampildataanggota (){
    model2.getDataVector().removeAllElements();
    model2.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_anggota";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[9];
                o[0]=r.getString("id_anggota");
                o[1]=r.getString("nama_anggota");
                o[2]=r.getString("alamat_anggota");
                o[3]=r.getString("tgl_lahir_anggota");
                o[4]=r.getString("tempat_lahir_anggota");
                o[5]=r.getString("jenis_kelamin_anggota");
                o[6]=r.getString("no_telepo_anggota");
                o[7]=r.getString("status_anggota");
                o[8]=r.getString("keterangan_anggota");
                model2.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    void tampildataanggotaaktif (){
    model2.getDataVector().removeAllElements();
    model2.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_anggota WHERE status_anggota = 'Aktif'";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[9];
                o[0]=r.getString("id_anggota");
                o[1]=r.getString("nama_anggota");
                o[2]=r.getString("alamat_anggota");
                o[3]=r.getString("tgl_lahir_anggota");
                o[4]=r.getString("tempat_lahir_anggota");
                o[5]=r.getString("jenis_kelamin_anggota");
                o[6]=r.getString("no_telepo_anggota");
                o[7]=r.getString("status_anggota");
                o[8]=r.getString("keterangan_anggota");
                model2.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    void tampildataanggotanonaktif (){
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_anggota WHERE status_anggota != 'Aktif'";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[9];
                o[0]=r.getString("id_anggota");
                o[1]=r.getString("nama_anggota");
                o[2]=r.getString("alamat_anggota");
                o[3]=r.getString("tgl_lahir_anggota");
                o[4]=r.getString("tempat_lahir_anggota");
                o[5]=r.getString("jenis_kelamin_anggota");
                o[6]=r.getString("no_telepo_anggota");
                o[7]=r.getString("status_anggota");
                o[8]=r.getString("keterangan_anggota");
                model2.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    void tableanggotasearch(){
        
            DefaultTableModel tabelTampil12 = new DefaultTableModel();
            tabelTampil12.addColumn("ID Anggota");
            tabelTampil12.addColumn("Nama");
            tabelTampil12.addColumn("Alamat");
            tabelTampil12.addColumn("Tgl. Lahir");
            tabelTampil12.addColumn("Tempat Lahir");
            tabelTampil12.addColumn("Jenis Kelamin");
            tabelTampil12.addColumn("No. Telp.");
            tabelTampil12.addColumn("Status Keanggotaan");
            tabelTampil12.addColumn("Keterangan");
        try{
             Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql = "Select * from tb_anggota where id_anggota like '%" + jTextField3.getText() + "%'" 
                         + "or nama_anggota like '%" + jTextField3.getText() + "%'"
                    + "or alamat_anggota like '%" + jTextField3.getText() + "%'"
                 +   "or tgl_lahir_anggota like '%" + jTextField3.getText() + "%'"
                    +   "or tempat_lahir_anggota like '%" + jTextField3.getText() + "%'"
                    + "or jenis_kelamin_anggota like '%" + jTextField3.getText() + "%'"
                    + "or status_anggota like '%" + jTextField3.getText() + "%'"
                    + "or no_telepo_anggota like '%" + jTextField3.getText() + "%'"
                    + "or keterangan_anggota like '%" + jTextField3.getText() + "%'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            tabelTampil12.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getString(8),
            rs.getString(7),
            rs.getString(9)
            });
            }
          jTable3.setModel(tabelTampil12);

                }catch (Exception e){
                    System.out.println(e);
            }
     }
    
    //    method pinjaman
    
    void tampildatapinjaman (){
    model3.getDataVector().removeAllElements();
    model3.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_pinjaman inner join tb_pinjaman_katagori on tb_pinjaman.id_pinajaman_katagori=tb_pinjaman_katagori.id_pinjaman_katagori inner join tb_anggota on tb_pinjaman.id_anggota=tb_anggota.id_anggota where keterangan_pinjaman = 'Belum Acc'";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[5];
                o[0]=r.getString("id_pinjaman");
                o[1]=r.getString("nama_pinjaman");
                o[2]=r.getString("nama_anggota");
                o[3]=r.getString("besar_pinjaman");
                o[4]=r.getString("tgl_pengajuan_pinjaman");
                model3.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    //    method simpanan

    void tampildatasimpanan (){
    model4.getDataVector().removeAllElements();
    model4.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_simpanan inner join tb_anggota on tb_simpanan.id_anggota=tb_anggota.id_anggota";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[6];
                o[0]=r.getString("id_simpanan");
                o[1]=r.getString("nama_simpanan");
                o[2]=r.getString("nama_anggota");
                o[3]=r.getString("tgl_simpanan");
                o[4]=r.getString("besar_simpanan");
                o[5]=r.getString("keterangan_simpanan");
                model4.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    //method angsur
    
    void tampildatapinjamanangsur (){
    model5.getDataVector().removeAllElements();
    model5.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql="SELECT * FROM tb_pinjaman inner join tb_pinjaman_katagori on tb_pinjaman.id_pinajaman_katagori=tb_pinjaman_katagori.id_pinjaman_katagori inner join tb_anggota on tb_pinjaman.id_anggota=tb_anggota.id_anggota where keterangan_pinjaman = 'Belum Lunas'";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[5];
                o[0]=r.getString("id_pinjaman");
                o[1]=r.getString("nama_pinjaman");
                o[2]=r.getString("nama_anggota");
                o[3]=r.getString("besar_pinjaman");
                o[4]=r.getString("tgl_pinjaman");
                model5.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenu5 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program Koperasi Simpan Pinjam - STIKI INDONESIA");

        jPanel3.setBackground(new java.awt.Color(204, 0, 51));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Logged in as :");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel8.setText("User Id : ");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel9.setText("User Id : ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("jLabel10");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(204, 0, 51));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jButton13.setText("Pinjaman Baru");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Detail Pinjaman");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Daftar Pengajuan Pinjaman");

        jButton15.setText("History ACC");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Pinjaman", jPanel6);

        jPanel14.setBackground(new java.awt.Color(204, 0, 51));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jButton16.setText("Simpanan Baru");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Detail Simpanan");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Daftar Simpanan Anggota");

        jButton6.setText("Refresh Data");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Simpanan", jPanel8);

        jPanel15.setBackground(new java.awt.Color(204, 0, 51));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jButton19.setText("Angsur");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Detail Angsuran");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Daftar Pinjaman");

        jButton7.setText("Refresh Data");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButton19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Angsuran", jPanel13);

        jPanel9.setBackground(new java.awt.Color(204, 0, 51));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Cari Data Anggota");

        jButton9.setLabel("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton10.setText("Tambah Data");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Ubah Data");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Hapus Data");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Anggota Koperasi");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton12))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 283, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Data Anggota", jPanel9);

        jPanel5.setBackground(new java.awt.Color(204, 0, 51));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Cari Data Petugas");

        jButton1.setLabel("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Tambah Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ubah Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setLabel("Aktif");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setLabel("Nonaktif");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Semua");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Daftar Petugas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addGap(43, 43, 43)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Data Petugas", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Data Management", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );

        jMenu3.setText("File");

        jMenu4.setText("User Management");

        jMenuItem1.setText("View User List");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem3.setText("Register User");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenu3.add(jMenu4);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tambahpetugas addpetugas=new tambahpetugas(this, rootPaneCheckingEnabled);
        addpetugas.show();
        addpetugas.setAlwaysOnTop(true);
        jTable1.setModel(model);
        tampildatapetugas();
        jTextField1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Barang");
            return;
        }
        else
        {
           String NamaPetugas=(String) jTable1.getValueAt(i, 1);
           String AlamaPetugas= (String) jTable1.getValueAt(i, 2);
           String NoTelpPetugas= (String) jTable1.getValueAt(i, 3);
           String TempatLahirPetugas= (String) jTable1.getValueAt(i, 4);
           String TglLahirPetugas=(String)jTable1.getValueAt(i, 5);
           String KetPetugas=(String)jTable1.getValueAt(i, 6);
           String IdPetugas=(String)jTable1.getValueAt(i, 0);
           
           String tgl=TglLahirPetugas;
           Date tg = null;
            try {
                tg = sdf.parse(tgl);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           tambahpetugas updatepetugas=new  tambahpetugas(this, rootPaneCheckingEnabled);
           updatepetugas.jLabel1.setText(" UPDATE DATA PETUGAS");
           updatepetugas.jButton1.setText("Update");
           updatepetugas.jComboBox1.setSelectedItem(KetPetugas);
           updatepetugas.jTextField1.setText(NamaPetugas);
           updatepetugas.jTextArea1.setText(AlamaPetugas);
           updatepetugas.jTextField2.setText(NoTelpPetugas);
           updatepetugas.jTextField3.setText(TempatLahirPetugas);
           
           updatepetugas.jXDatePicker1.setDate(tg);
           updatepetugas.idpetugas=IdPetugas;
           updatepetugas.show();
           updatepetugas.setAlwaysOnTop(true);
           jTable1.setModel(model);
           tampildatapetugas();
           jTextField1.setText("");
           }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         int i=jTable1.getSelectedRow();
            if (i==-1)
            {
                JOptionPane.showMessageDialog(this, "Belum Memilih Data");
            return;
            }
            else{
        try {
            
           String idpetugas=(String) jTable1.getValueAt(i, 0);
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            //executequery untuk menampilkan data
            //executeupdate untuk menambah/simpan, edit data
            
             int jawaban = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ?",
                "Pertanyaan",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
       if (jawaban==JOptionPane.YES_OPTION)
       {
           statement.executeUpdate("delete from tb_petugas where id_petugas=('"+idpetugas+"');");
            statement.close();
       }
       else 
            {
           return;
                    }
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            tampildatapetugas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapus\n"+e.getMessage());
        }
                    }
              jTable1.setModel(model);
               tampildatapetugas();        
     jTextField1.setText("");
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tablepetugassearch();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        // TODO add your handling code here:
        tampildatapetugas();
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
        tampildatapetugasaktif();
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
        tampildatapetugasnonaktif();
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        tableanggotasearch();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        dialoganggota addanggota=new dialoganggota(this, rootPaneCheckingEnabled);
        addanggota.show();
        addanggota.setAlwaysOnTop(true);
        jTable3.setModel(model2);
        tampildataanggota();
        jTextField3.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int i=jTable3.getSelectedRow();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Anggota");
            return;
        }
        else
        {
           String NamaAnggota=(String) jTable3.getValueAt(i, 1);
           String AlamatAnggota= (String) jTable3.getValueAt(i, 2);
           String TglLahirAnggota= (String) jTable3.getValueAt(i, 3);
           String TempatLahirAnggota= (String) jTable3.getValueAt(i, 4);
           String JenisKelaminAnggota=(String)jTable3.getValueAt(i, 5);
           String NoTelpAnggota=(String)jTable3.getValueAt(i, 6);
           String KetAnggota=(String)jTable3.getValueAt(i, 8);
           String IdAnggota=(String)jTable3.getValueAt(i, 0);
           
           String tgl=TglLahirAnggota;
           Date tg = null;
            try {
                tg = sdf.parse(tgl);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           dialoganggota updateanggota=new dialoganggota(this, rootPaneCheckingEnabled);
           updateanggota.jLabel1.setText(" UPDATE DATA ANGGOTA");
           updateanggota.jButton1.setText("Update");
           updateanggota.jTextField1.setText(NamaAnggota);
           updateanggota.jTextArea1.setText(AlamatAnggota);
            if (JenisKelaminAnggota.equals("Laki-Laki")) {
                updateanggota.jRadioButton1.setSelected(true);
            } else if (JenisKelaminAnggota.equals("Perempuan")){
                updateanggota.jRadioButton2.setSelected(true);
            }
           updateanggota.jTextField2.setText(TempatLahirAnggota);
           updateanggota.jTextField3.setText(NoTelpAnggota);
           updateanggota.jTextArea2.setText(KetAnggota);
           
           updateanggota.jXDatePicker1.setDate(tg);
           updateanggota.idanggota=IdAnggota;
           updateanggota.show();
           updateanggota.setAlwaysOnTop(true);
           jTable3.setModel(model2);
           tampildataanggota();
           jTextField3.setText("");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        int i=jTable3.getSelectedRow();
            if (i==-1)
            {
                JOptionPane.showMessageDialog(this, "Belum Memilih Data");
            return;
            }
            else{
        try {
            
           String idanggota =(String) jTable3.getValueAt(i, 0);
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
             int jawaban = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini ?",
                "Pertanyaan",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
       if (jawaban==JOptionPane.YES_OPTION)
       {
           statement.executeUpdate("delete from tb_anggota where id_anggota=('"+idanggota+"');");
            statement.close();
       }
       else 
            {
           return;
                    }
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            tampildataanggota();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapus\n"+e.getMessage());
        }
                    }
        jTable3.setModel(model2);
        tampildataanggota();        
        jTextField3.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        login login= new login();
        int k = JOptionPane.showConfirmDialog(this, "Yakin ingin logout?",
            "Anda Ingin Logout ?",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE
        );
        if (k==JOptionPane.YES_OPTION)
        {
            login.show();
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        register register = new register();
        register.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dialoguser user = new dialoguser();
        user.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        pinjamanbaru add = new pinjamanbaru();
        add.show();
        jTable4.setModel(model3);
        tampildatapinjaman();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        int i=jTable4.getSelectedRow();
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Pengajuan");
            return;
        }
        else
        {
           String IdPinjaman=(String) jTable4.getValueAt(i, 0);
           String KategooriPinjaman= (String) jTable4.getValueAt(i, 1);
           String Anggota= (String) jTable4.getValueAt(i, 2);
           String BesarPinjaman= (String) jTable4.getValueAt(i, 3);
           String TanggalPengajuan=(String)jTable4.getValueAt(i, 4);
           
           detailpengajuan detail=new detailpengajuan(this, rootPaneCheckingEnabled);
           detail.jLabel7.setText(IdPinjaman);
           detail.jLabel8.setText(KategooriPinjaman);
           detail.jLabel9.setText(Anggota);
           detail.jLabel10.setText(BesarPinjaman);
           detail.jLabel11.setText(TanggalPengajuan);
           detail.show();
           detail.setAlwaysOnTop(true);
           jTable4.setModel(model3);
           tampildatapinjaman();
           jTextField3.setText("");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        historypinjaman history = new historypinjaman(this, rootPaneCheckingEnabled);
        history.show();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        tampildatapinjaman();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        simpananbaru add = new simpananbaru();
        add.show();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        int i=jTable5.getSelectedRow();
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Pengajuan");
            return;
        }
        else
        {
           String IdSimpanan=(String) jTable5.getValueAt(i, 0);
           String NamaSimpanan= (String) jTable5.getValueAt(i, 1);
           String Anggota= (String) jTable5.getValueAt(i, 2);
           String TanggalSimpanan= (String) jTable5.getValueAt(i, 3);
           String BesarSimpanan=(String)jTable5.getValueAt(i, 4);
           String Keterangan=(String)jTable5.getValueAt(i, 5);
           
           detailsimpanan detail=new detailsimpanan(this, rootPaneCheckingEnabled);
           detail.jTextField1.setText(IdSimpanan);
           detail.jTextField3.setText(NamaSimpanan);
           detail.jTextField2.setText(Anggota);
           detail.jTextField4.setText(TanggalSimpanan);
           detail.jTextField5.setText(BesarSimpanan);
           detail.jTextField6.setText(Keterangan);
           detail.show();
           detail.setAlwaysOnTop(true);
           jTable5.setModel(model4);
           tampildatasimpanan();
           jTextField3.setText("");
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        tampildatasimpanan();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6MouseClicked

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        int i=jTable6.getSelectedRow();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Pinjaman");
            return;
        }
        else
        {
           String IdPinjaman=(String) jTable6.getValueAt(i, 0);
           String KategoriPinjaman= (String) jTable6.getValueAt(i, 1);
           String Anggota= (String) jTable6.getValueAt(i, 2);
           String BesarPinjaman= (String) jTable6.getValueAt(i, 3);
           String TanggalPengajuan=(String)jTable6.getValueAt(i, 4);
           
           angsuran angsuran=new angsuran(this, rootPaneCheckingEnabled);
           angsuran.jTextField1.setText(IdPinjaman);
           angsuran.jLabel5.setText(BesarPinjaman);
           angsuran.show();
           angsuran.setAlwaysOnTop(true);
           jTable6.setModel(model5);
           tampildatapinjamanangsur();
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        int i=jTable6.getSelectedRow();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Pinjaman");
            return;
        }
        else
        {
           String IdPinjaman=(String) jTable6.getValueAt(i, 0);
           String KategoriPinjaman= (String) jTable6.getValueAt(i, 1);
           String Anggota= (String) jTable6.getValueAt(i, 2);
           String BesarPinjaman= (String) jTable6.getValueAt(i, 3);
           String TanggalPengajuan=(String)jTable6.getValueAt(i, 4);
           
           detailangsuran angsuran=new detailangsuran(this, rootPaneCheckingEnabled);
           angsuran.jLabel7.setText(IdPinjaman);
           angsuran.jLabel8.setText(KategoriPinjaman);
           angsuran.jLabel9.setText(Anggota);
           angsuran.jLabel10.setText(BesarPinjaman);
           angsuran.jLabel11.setText(TanggalPengajuan);
           angsuran.show();
           angsuran.setAlwaysOnTop(true);
           jTable6.setModel(model5);
           tampildatapinjamanangsur();
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        tampildatapinjamanangsur();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    public javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTabbedPane jTabbedPane3;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable3;
    public javax.swing.JTable jTable4;
    public javax.swing.JTable jTable5;
    public javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
