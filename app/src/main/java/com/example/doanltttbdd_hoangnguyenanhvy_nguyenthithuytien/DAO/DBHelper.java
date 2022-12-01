package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper instance = null;

    //Tạo database
    public  static final String DB_Name = "DOAN_De15_AnhVy_Tien";
    public static final int DB_Version = 1;
    public DBHelper(@Nullable Context context)  {
        super(context, DB_Name,null, DB_Version);
        instance = this;
    }

    public static DBHelper getInstance()
    {
        instance.getWritableDatabase();
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //1. Tạo và insert thông tin Kho
        String taoKHO = "CREATE TABLE tbKho " +
                " ( MAKHO INTEGER primary key autoincrement," +
                " TENKHO TEXT ) " ;
        String nhapKHO ="INSERT INTO tbKho (TENKHO) VALUES ('Kho Củ Chi')";
        sqLiteDatabase.execSQL(taoKHO);
        sqLiteDatabase.execSQL(nhapKHO);

        //2. Tạo và insert thông tin Loại sản phẩm
        String taoLoaisp = "CREATE TABLE tbLoaisp (" +
                " MALOAISP INTEGER primary key autoincrement," +
                " TENLOAISP TEXT ) ";
        String nhapLoaisp = "INSERT INTO tbLoaisp (TENLOAISP) VALUES " +
                "('Văn học'), " +
                "('Manga - Comic'), " +
                "('Sách giáo khoa'), " +
                "('Văn phòng phẩm - Dụng cụ học tập'), " +
                "('Đồ chơi') ";
        sqLiteDatabase.execSQL(taoLoaisp);
        sqLiteDatabase.execSQL(nhapLoaisp);

        //3. Tạo và insert thông tin Sản phẩm
        String taoSp = "CREATE TABLE tbsanpham ( " +
                " MASP INTEGER primary key autoincrement, " +
                " TENSP TEXT," +
                " LUONGTON INTEGER," +
                " DONGIA REAL, " +
                " DVT TEXT, " +
                " ANH TEXT, " +
                " MALOAISP TEXT, " +
                " MAKHO TEXT, " +
                " CONSTRAINT FK_MALOAISP_tbsanpham FOREIGN KEY (MALOAISP) REFERENCES tbLoaisp(MALOAISP) ON DELETE CASCADE, " +
                " CONSTRAINT FK_MAKHO_tbsanpham FOREIGN KEY (MAKHO) REFERENCES tbKho(MAKHO) ON DELETE CASCADE );";
        String nhapSp1 = "INSERT INTO tbsanpham (TENSP, LUONGTON, DONGIA, DVT, ANH, MALOAISP, MAKHO) VALUES " +
                " ('Túp lều bác Tom', 365, 78000, 'Quyển', 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_86539.jpg','1', '1'), " +
                " ('Cây cam ngọt của tôi', 100, 108000, 'Quyển','https://cdn0.fahasa.com/media/catalog/product/i/m/image_217480.jpg', '1', '1'), " +
                " ('Tâm lý học - Phác họa chân dung kẻ phạm tội', 59, 145000, 'Quyển', 'https://cdn0.fahasa.com/media/catalog/product/p/h/ph_c-h_a-ch_n-dung-k_-ph_m-t_i.jpg','1', '1'), " +
                " ('Nhà giả kim', 35, 79000, 'Quyển', 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_195509_1_36793.jpg', '1', '1'), " +
                " ('Những vị thần nưThần thoại Bắc Âuớc Mỹ', 505, 204000, 'Quyển',  'https://cdn0.fahasa.com/media/catalog/product/i/m/image_244718_1_5475.jpg','1', '1'), " +
                " ('Thần thoại Bắc Âu', 235, 104000, 'Quyển','https://cdn0.fahasa.com/media/catalog/product/i/m/image_195509_1_26262.jpg', '1', '1');";
        String nhapSp2 = "INSERT INTO tbsanpham (TENSP, LUONGTON, DONGIA, DVT, ANH, MALOAISP, MAKHO) VALUES " +
                " ('Birdmen - Tập 1', 69, 30000, 'Cuốn','https://cdn0.fahasa.com/media/catalog/product/b/i/birdmen---tap-1_1.jpg', '2', '1'), " +
                " ('Birdmen - Tập 2', 485, 30000, 'Cuốn','https://cdn0.fahasa.com/media/catalog/product/b/i/birdmen---tap-2.jpg', '2', '1'), " +
                " ('Look Back', 59, 35000, 'Cuốn','https://cdn0.fahasa.com/media/catalog/product/_/l/_look-back_b_a-_o.jpg','2', '1'), " +
                " ('Thị trấn vắng mình tôi - Tập 6', 95, 58000, 'Cuốn','https://cdn0.fahasa.com/media/catalog/product/z/3/z3853755095512_8219f293029a8cc4b3c17ec3b09c7756.jpg','2', '1'), " +
                " ('Chú thuật hồi chiến - Tập 8', 15, 24000, 'Cuốn','https://cdn0.fahasa.com/media/catalog/product/c/h/chu-thuat-hoi-chien---tap-8---ban-thuong-_mockup_-_1_.jpg','2', '1'), " +
                " ('Lớp học rùng rợn - Tập 3', 5, 30000, 'Cuốn','https://cdn0.fahasa.com/media/catalog/product/l/o/lop-hoc-rung-ron---tap-3.jpg','2', '1');";
        String nhapSp3 = "INSERT INTO tbsanpham (TENSP, LUONGTON, DONGIA, DVT, ANH, MALOAISP, MAKHO) VALUES " +
                " ('Sách giáo khoa bộ lớp 12 - Sách bài học (Bộ 14 cuốn)', 165, 180000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/3/3/3300000015422-1.jpg','3', '1')," +
                " ('Sách giáo khoa bộ lớp 12 - Sách bài tập (Bộ 11 cuốn)', 665, 165000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/3/3/3300000015439-1.jpg', '3', '1')," +
                " ('Mĩ thuật 1 (Cánh diều) (2022)', 355, 13000, 'Quyển', 'https://cdn0.fahasa.com/media/catalog/product/9/7/9786045485187.jpg','3', '1')," +
                " ('Tự nhiên và xã hội 1 (Cánh diều) (2022)', 565, 27000, 'Quyển', 'https://cdn0.fahasa.com/media/catalog/product/9/7/9786045485170.jpg','3', '1')," +
                " ('Vở chính tả 1 (Kết nối)', 2, 14000, 'Quyển', 'https://cdn0.fahasa.com/media/catalog/product/9/7/9786043152432.jpg','3', '1');";
        String nhapSp4 = "INSERT INTO tbsanpham (TENSP, LUONGTON, DONGIA, DVT, ANH, MALOAISP, MAKHO) VALUES " +
                " ('Lịch để bàn Teen Mini 2023', 400, 10000, 'Cái', 'https://cdn0.fahasa.com/media/catalog/product/3/3/3300000023328.jpg', '4', '1')," +
                " ('Ba lô bông hình Doraemon', 20, 249000, 'Cái', 'https://cdn0.fahasa.com/media/catalog/product/8/9/8936134261319.jpg', '4', '1')," +
                " ('Bút chì gỗ họa tiết 2B Unicorn', 321, 4000, 'Cây', 'https://cdn0.fahasa.com/media/catalog/product/8/9/8935276427102.jpg','4', '1')," +
                " ('Sổ bìa da kẻ ngang 180 trang 80 gsm - TheSun', 30, 75000, 'Cuốn', 'https://cdn0.fahasa.com/media/catalog/product/8/9/8934986008137.jpg','4', '1')," +
                " ('Bóp Viết Eva Avengers Blue', 12, 145000, 'Cái', 'https://cdn0.fahasa.com/media/catalog/product/8/9/8936183839422.jpg','4', '1')," +
                " ('Máy Tính Casio FX 580 VN X', 12, 719000, 'Cái', 'https://cdn0.fahasa.com/media/catalog/product/2/_/2_88.jpg','4', '1');";
        String nhapSp5 = "INSERT INTO tbsanpham ( TENSP, LUONGTON, DONGIA, DVT,ANH,  MALOAISP, MAKHO) VALUES" +
                " ('Lớp học mật ngữ: Cuộc đua sao chổi', 40, 440000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/e/b/eb7f9af9bc5cb8e852f206448b13d556.jpg','5', '1')," +
                " ('Đồ Chơi Lắp Ráp Mô Hình SD Gundam World Heroes No.03', 406, 183000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/4/5/4573102615503.jpg', '5', '1')," +
                " ('Bộ Cờ Chiến Thuật SD Gundam World Heroes Ver 1', 780, 119000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/4/5/4549660641131.jpg','5', '1')," +
                " ('Thẻ Bài Ma Sói Character Việt Hóa', 360, 123000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/8/9/8936121470175_1.jpg','5', '1')," +
                " ('Rubik 3x3 FanXin 581', 901, 35000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/i/m/image_233599.jpg', '5', '1')," +
                " ('Đồ Chơi Con Sâu 3D', 1540, 92000, 'Bộ', 'https://cdn0.fahasa.com/media/catalog/product/8/9/8935306032030.jpg', '5', '1');";
        sqLiteDatabase.execSQL(taoSp);
        sqLiteDatabase.execSQL(nhapSp1);
        sqLiteDatabase.execSQL(nhapSp2);
        sqLiteDatabase.execSQL(nhapSp3);
        sqLiteDatabase.execSQL(nhapSp4);
        sqLiteDatabase.execSQL(nhapSp5);

        //4. Tạo và insert thông tin Chức vụ
        String taoCV = "CREATE TABLE tbChucvu " +
                "( MACV INTEGER primary key autoincrement," +
                " TENCV TEXT )";
        String NhapCV ="INSERT INTO tbChucvu (TENCV) VALUES " +
                " ('Quản trị hệ thống')," +
                " ('Nhân viên tiếp nhận đơn hàng')," +
                " ('Nhân viên đóng gói')," +
                " ('Nhân viên vận chuyển')," +
                " ('Kế toán')";
        sqLiteDatabase.execSQL(taoCV);
        sqLiteDatabase.execSQL(NhapCV);

        //5. Tạo và insert thông tin nhân viên
        String taoNV ="CREATE TABLE tbNhanvien ( " +
                " MANV INTEGER primary key autoincrement, " +
                " HOTENNV TEXT," +
                " SDT TEXT," +
                " MATKHAU TEXT," +
                " MACV TEXT," +
                " CONSTRAINT FK_MACV_tbNhanvien FOREIGN KEY (MACV) REFERENCES tbChucvu(MACV) ON DELETE CASCADE " +
                ")";
        String nhapNV = "INSERT INTO tbNhanvien (HOTENNV, SDT, MATKHAU, MACV) VALUES " +
                " ('Phạm Thanh Nhân', '0344530001', '987654321', '1'), " +
                " ('Lê Hải Phương', '0344530002', '987654321', '1')," +
                " ('Trương Thị Quỳnh', '0344530003', '987654321', '2')," +
                " ('Đăng Văn Sang', '0344530004', '987654321', '2')," +
                " ('Trần Xuân Thái', '0344530005', '987654321', '3')," +
                " ('Hà Thu Uyên', '0344530006', '987654321', '3')," +
                " ('Phương Lập Vinh', '0344530007', '987654321', '4')," +
                " ('Trần Quang Bình', '0344530008', '987654321', '4')," +
                " ('Lý Văn Hưng', '0344530009', '987654321', '5')," +
                " ('Phí Phương Yên', '0344530010', '987654321', '5')";
        sqLiteDatabase.execSQL(taoNV);
        sqLiteDatabase.execSQL(nhapNV);

        //6. Tạo và Insert thông tin khách hàng
        String taoKH = "CREATE TABLE tbKhachhang" +
                "( MAKH INTEGER primary key autoincrement , " +
                " HOKH TEXT ," +
                " TENKH TEXT ," +
                " SDT  TEXT ," +
                " DIACHI TEXT," +
                " EMAIL TEXT ," +
                " GIOITINH TEXT CHECK (GIOITINH IN('Nam','Nữ'))," +
                " NGAYSINH TEXT ," +
                " MATKHAU TEXT ," +
                " TINHTRANG TEXT CHECK (TINHTRANG IN('Khóa','Hoạt động') ) ," +
                " GHICHU TEXT )";
        sqLiteDatabase.execSQL(taoKH);
        String NhapKH = "INSERT INTO tbKhachhang (HOKH, TENKH, SDT, DIACHI, EMAIL, GIOITINH, NGAYSINH, MATKHAU, TINHTRANG) VALUES " +
                " ('Nguyễn Văn', 'Ánh', '0347890001', 'Số 84,Thôn 5, Xã Phú Xuân, Huyện Krong Năng, Tỉnh Đắk Lắk', 'anhnv@gmail.com', 'Nam', '1990-01-01', '123456789', 'Hoạt động'), " +
                " ('Tạ Văn', 'Bảo', '0347890002', 'Số 51,Kp3, Phường Mỹ Phước, TX Bến Cát, Tỉnh Bình Dương', 'baotv@gmail.com', 'Nam', '1991-02-22', '123456789', 'Khóa'), " +
                " ('Huỳnh Thị', 'Chi', '0347890003', 'Số 54, Đường 12D, Phường Long Thạnh Mỹ, TP. Thủ Đức', 'chiht@gmail.com', 'Nữ', '1992-03-13', '123456789', 'Khóa'), " +
                " ('Trương Thị', 'Dung', '0347890004', 'Số 208, Đường Hoàng Diệu 2,TP. Thủ Đức', 'dungtt@gmail.com', 'Nữ', '1993-04-24', '123456789', 'Hoạt động'), " +
                " ('Tô Văn', 'Giang', '0347890005', 'Số 225, Phường Chánh Phú Hòa, TX Bến Cát, Bình Dương', 'giangtv@gmail.com', 'Nam', '1994-05-15', '123456789', 'Hoạt động'), " +
                " ('Trần Thị', 'Hiền', '0347890006', 'Số 12, Thôn 10, Xã EaDrong, TX Buôn Hồ, Tỉnh Đắk Lắk', 'hientt@gmail.com', 'Nữ', '1995-06-26', '123456789', 'Hoạt động')," +
                " ('Lâm Chí', 'Kiệt', '0347890007', 'Hẻm 385, Số 12, Phường Tăng Nhơn Phú A, TP. Thủ Đức', 'kietlc@gmail.com', 'Nam', '1996-07-07', '123456789', 'Hoạt động')," +
                " ('Hồ Gia', 'Linh', '0347890008', 'Số 112, Phường Phước Long B, TP. Thủ Đức', 'linhhg@gmail.com', 'Nam', '1997-08-18', '123456789', 'Khóa')," +
                " ('Khương Nhật', 'Mai', '0347890009', 'Số 22, Xóm 4, Xã Quỳnh Lương, Huyện Quỳnh Lưu, Tỉnh Nghệ An', 'maikn@gmail.com', 'Nam', '1998-09-29', '123456789', 'Hoạt động')," +
                " ('Lại Diệp', 'Nhi', '0347890010', 'Số 273,Đường Lê Văn Việt, TP. Thủ Đức', 'nhild@gmail.com', 'Nữ', '1999-10-10', '123456789', 'Hoạt động')";
        sqLiteDatabase.execSQL(NhapKH);


        //7. Tạo và insert thông tin giỏ hàng
        String taoGiohang = "CREATE TABLE tbGiohang ( " +
                " MAGH INTEGER primary key autoincrement," +
                " TONGSL INTEGER CHECK (TONGSL <= 100 )," +
                " MAKH INTEGER," +
                " CONSTRAINT FK_MAKH_tbGiohang FOREIGN KEY (MAKH) REFERENCES tbKhachhang(MAKH) ON DELETE CASCADE);";
        String nhapGiohang = "INSERT INTO tbGiohang (TONGSL, MAKH) VALUES " +
                " ('24', '1')," +
                " ('59', '2')," +
                " ('14', '3')," +
                " ('41', '4')," +
                " ('75', '5')," +
                " ('34', '6')," +
                " ('42', '7')," +
                " ('23', '8')," +
                " ('17', '9')," +
                " ('33', '10');";
        sqLiteDatabase.execSQL(taoGiohang);
        sqLiteDatabase.execSQL(nhapGiohang);

        //8. Tạo và insert thông tin Chi tiết giỏ hàng
        String taoCTGH = "CREATE TABLE tbCTGH ("+
                " MAGH INTEGER ," +
                " MASP INTEGER ," +
                " SL INTEGER," +
                " PRIMARY KEY(MAGH,MASP), " +
                " CONSTRAINT FK_MASP_tbCTGH FOREIGN KEY (MASP) REFERENCES  tbsanpham(MASP)  ON DELETE CASCADE," +
                " CONSTRAINT FK_MAGH_tbCTGH FOREIGN KEY (MAGH) REFERENCES  tbGiohang(MAGH)  ON DELETE CASCADE );";
        String nhapCTGH = "INSERT INTO tbCTGH (MAGH, MASP, SL) VALUES " +
                " ('1', '1', 10)," +
                " ('1', '2', 2)," +
                " ('1', '3', 7)," +
                " ('1', '4', 5)," +
                " ('2', '07', 11)," +
                " ('2', '10', 25)," +
                " ('2', '15', 8)," +
                " ('2', '18', 15)," +
                " ('3', '9', 8)," +
                " ('3', '11', 2)," +
                " ('3', '14', 1)," +
                " ('3', '19', 3)," +
                " ('4', '20', 5)," +
                " ('4', '29', 8)," +
                " ('4', '26', 7)," +
                " ('4', '28', 21)," +
                " ('5', '13', 10)," +
                " ('5', '23', 19)," +
                " ('5', '28', 7)," +
                " ('5', '27', 39)," +
                " ('6', '3', 12)," +
                " ('6', '6', 2)," +
                " ('6', '16', 8)," +
                " ('6', '7', 12)," +
                " ('7', '8', 1)," +
                " ('7', '9', 2)," +
                " ('7', '17', 25)," +
                " ('7', '19', 14)," +
                " ('8', '20', 5)," +
                " ('8', '22', 8)," +
                " ('8', '23', 6)," +
                " ('8', '24', 4)," +
                " ('9', '26', 1)," +
                " ('9', '27', 6)," +
                " ('9', '29', 9)," +
                " ('9', '6', 1)," +
                " ('10', '1', 5)," +
                " ('10', '2', 9)," +
                " ('10', '5', 4)," +
                " ('10', '9', 15);";
        sqLiteDatabase.execSQL(taoCTGH);
        sqLiteDatabase.execSQL(nhapCTGH);

        //9. Tạo và insert thông tin Tình trạng
        String taoTinhTrang = "CREATE TABLE tbTinhtrangdonhang ( " +
                " MATT INTEGER primary key autoincrement," +
                " TENTT TEXT );";
        String nhapTinhTrang ="INSERT INTO tbTinhtrangdonhang (TENTT) VALUES " +
                " ('Chờ xác nhận')," +
                " ('Xác nhận thành công, chờ đóng gói')," +
                " ('Chờ vận chuyển')," +
                " ('Đang giao hàng')," +
                " ('Giao hàng thành công');";
        sqLiteDatabase.execSQL(taoTinhTrang);
        sqLiteDatabase.execSQL(nhapTinhTrang);

        //10. Tạo và insert thông tin Đơn hàng
        String taoDH = "CREATE TABLE tbdonhang (" +
                " MADH INTEGER primary key autoincrement ," +
                " PTVC TEXT," +
                " PTTT TEXT," +
                " NGAYTAO TEXT," +
                " MAKH INTEGER," +
                " MATT INTEGER," +
                " GHICHU TEXT," +
                " CONSTRAINT FK_MAKH_tbdonhang FOREIGN KEY (MAKH) REFERENCES  tbKhachhang(MAKH)  ON DELETE CASCADE," +
                " CONSTRAINT FK_MAKH_tbTinhtrangdonhang FOREIGN KEY (MATT) REFERENCES  tbTinhtrangdonhang(MATT)  ON DELETE CASCADE )";
        String nhapDH = "INSERT INTO tbdonhang (PTVC, PTTT,NGAYTAO,MAKH,MATT, GHICHU)" +
                "VALUES " +
                "('Tiêu chuẩn', 'Tiền mặt','2022-11-07','1','1','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-11-19','2','1','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-11-18','3','1','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-11-05','4','1','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-11-19','5','2','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-07-15','6','2','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-08-06','7','2','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-10-06','8','2','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-10-21','9','3','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-10-23','10','3','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-10-21','1','4','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-10-22','2','4','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-10-03','3','5','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-09-20','4','5','')," +
                "('Tiêu chuẩn', 'Tiền mặt','2022-09-21','4','5','');";
        sqLiteDatabase.execSQL(taoDH);
        sqLiteDatabase.execSQL(nhapDH);

        //11. Tạo và insert thông tin Hóa đơn
        String taoHD = "CREATE TABLE tbhoadon ( " +
                " MAHD INTEGER primary key autoincrement ," +
                " NGAYTAO TEXT," +
                " TONGTIEN REAL," +
                " MAKH INTEGER," +
                " MADH INTEGER," +
                " CONSTRAINT FK_MAKH_tbhoadon FOREIGN KEY (MAKH) REFERENCES  tbKhachhang(MAKH)  ON DELETE CASCADE," +
                " CONSTRAINT FK_MAKH_tbhoadon FOREIGN KEY (MADH) REFERENCES  tbdonhang(MADH)  ON DELETE CASCADE )";
        String nhapHD = "INSERT INTO tbhoadon ( NGAYTAO, TONGTIEN, MAKH, MADH)" +
                " VALUES " +
                " ('2022-11-07',729000,'1','1')," +
                " ('2022-11-19',2014000,'2','2')," +
                " ('2022-11-18',542000,'3','3')," +
                " ('2022-11-05',922000,'4','4')," +
                " ('2022-11-19',1675000,'5','5')," +
                " ('2022-07-15',4460000,'6','6')," +
                " ('2022-08-06',1202000,'7','7')," +
                " ('2022-10-06',1142000,'8','8')," +
                " ('2022-10-21',1199000,'9','9')," +
                " ('2022-10-23',2070000,'10','10')," +
                " ('2022-10-21',245000,'1','11')," +
                " ('2022-10-22',788000,'2','12')," +
                " ('2022-10-03',2111000,'3','13')," +
                " ('2022-09-20',10016000,'4','14')," +
                " ('2022-09-21',742000,'4','15');";
        sqLiteDatabase.execSQL(taoHD);
        sqLiteDatabase.execSQL(nhapHD);


        //12. Tạo và insert thông tin Chi tiết hóa đơn
        String taoCTHD = "CREATE TABLE tbCthd ( " +
                " MAHD INTEGER," +
                " MASP INTEGER," +
                " SL INTEGER," +
                " PRIMARY KEY(MAHD,MASP)," +
                " CONSTRAINT FK_MAHD_tbhoadon FOREIGN KEY (MAHD) REFERENCES  tbhoadon(MAHD) ON DELETE CASCADE," +
                " CONSTRAINT FK_MASP_tbhoadon FOREIGN KEY (MASP) REFERENCES  tbsanpham(MASP) ON DELETE CASCADE" +
                ")";
        String nhapCTHD = "INSERT INTO tbCthd (MAHD, MASP, SL)" +
                " VALUES " +
                "  ('1','1',1)," +
                "  ('1','2',2)," +
                "  ('1','3',3)," +
                "  ('2','4',4)," +
                "  ('2','5',5)," +
                "  ('2','6',2)," +
                "  ('2','7',4)," +
                "  ('2','8',7)," +
                "  ('2','9',4)," +
                "  ('3','10',8)," +
                "  ('3','11',2)," +
                "  ('3','12',1)," +
                "  ('4','13',3)," +
                "  ('4','14',2)," +
                "  ('4','15',4)," +
                "  ('5','16',3)," +
                "  ('5','17',5)," +
                "  ('5','18',3)," +
                "  ('5','19',6)," +
                "  ('6','20',7)," +
                "  ('6','21',3)," +
                "  ('6','22',9)," +
                "  ('6','23',2)," +
                "  ('6','24',3)," +
                "  ('7','25',4)," +
                "  ('7','26',1)," +
                "  ('7','27',2)," +
                "  ('7','28',3)," +
                "  ('8','29',4)," +
                "  ('8','1',3)," +
                "  ('8','2',5)," +
                "  ('9','3',5)," +
                "  ('9','4',6)," +
                "  ('10','5',7)," +
                "  ('10','6',3)," +
                "  ('10','7',5)," +
                "  ('10','8',6)," +
                "  ('11','9',3)," +
                "  ('11','10',2)," +
                "  ('11','11',1)," +
                "  ('12','12',1)," +
                "  ('12','13',1)," +
                "  ('12','14',2)," +
                "  ('12','15',1)," +
                "  ('12','16',3)," +
                "  ('12','17',11)," +
                "  ('13','18',10)," +
                "  ('13','19',5)," +
                "  ('13','20',9)," +
                "  ('13','21',2)," +
                "  ('13','22',4)," +
                "  ('14','23',5)," +
                "  ('14','24',7)," +
                "  ('14','25',2)," +
                "  ('14','26',25)," +
                "  ('15','27',5)," +
                "  ('15','28',1)," +
                "  ('15','29',1);";
        sqLiteDatabase.execSQL(taoCTHD);
        sqLiteDatabase.execSQL(nhapCTHD);

        //13. Tạo và insert thông tin Lịch sử đơn hàng
        String taoLSDH = "CREATE TABLE tbLichsudh (" +
                " MADH  INTEGER," +
                " MATT  INTEGER," +
                " MANV  INTEGER," +
                " NGAY TEXT," +
                " PRIMARY KEY(MADH,MATT)," +
                " CONSTRAINT FK_MADH_tbLichsudh FOREIGN KEY (MADH) REFERENCES  tbdonhang(MADH) ON DELETE CASCADE," +
                " CONSTRAINT FK_MADH_tbLichsudh FOREIGN KEY (MATT) REFERENCES  tbTinhtrangdonhang(MATT) ON DELETE CASCADE," +
                " CONSTRAINT FK_MANV_tbLichsudh FOREIGN KEY (MANV) REFERENCES  tbNhanvien(MANV) ON DELETE CASCADE )";
        String nhapLSDH1 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY) " +
                "  VALUES " +
                "   ('1', '1',NULL, '2022-11-07'), " +
                "   ('2', '1',NULL, '2022-11-19'), " +
                "   ('3', '1',NULL, '2022-11-18'), " +
                "   ('4', '1',NULL, '2022-11-05') ";

        String nhapLSDH2 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('5', '1',NULL, '2022-11-19'),  " +
                "      ('5', '2','NV03', '2022-11-20');";
        String nhapLSDH3 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('6', '1',NULL, '2022-07-15'),  " +
                "      ('6', '2','NV03', '2022-07-17');";
        String nhapLSDH4 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('7', '1',NULL, '2022-08-06'),  " +
                "      ('7', '2','NV03', '2022-08-09');";
        String nhapLSDH5 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('8', '1',NULL, '2022-10-06'),  " +
                "      ('8', '2','NV03', '2022-10-07');";
        String nhapLSDH6 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('9', '1',NULL, '2022-10-21'),  " +
                "      ('9', '2','NV03', '2022-10-23'),  " +
                "      ('9', '3','NV05', '2022-10-23');";
        String nhapLSDH7 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('10', '1',NULL, '2022-10-23'),  " +
                "      ('10', '2','NV03', '2022-10-23'),  " +
                "      ('10', '3','NV05', '2022-10-24');";
        String nhapLSDH8 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('11', '1',NULL, '2022-10-21'),  " +
                "      ('11', '2','NV03', '2022-10-21'),  " +
                "      ('11', '3','NV05', '2022-10-22'),  " +
                "      ('11', '4','NV07', '2022-10-24');";
        String nhapLSDH9 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('12', '1',NULL, '2022-10-22'),  " +
                "      ('12', '2','NV03', '2022-10-22'),  " +
                "      ('12', '3','NV05', '2022-10-22'),  " +
                "      ('12', '4','NV07', '2022-10-25');";
        String nhapLSDH10 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('13', '1',NULL, '2022-10-03'),  " +
                "      ('13', '2','NV04', '2022-10-03'),  " +
                "      ('13', '3','NV05', '2022-10-05'),  " +
                "      ('13', '4','NV08', '2022-10-06'),  " +
                "      ('13', '5','NV08', '2022-10-06');  ";
        String nhapLSDH11 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('14', '1',NULL, '2022-09-20'),  " +
                "      ('14', '2','NV04', '2022-09-21'),  " +
                "      ('14', '3','NV06', '2022-09-22'),  " +
                "      ('14', '4','NV08', '2022-09-23'),  " +
                "      ('14', '5','NV08', '2022-09-24');";
        String nhapLSDH12 = "INSERT INTO tbLichsudh (MADH, MATT, MANV, NGAY)  " +
                "    VALUES  " +
                "      ('15', '1',NULL, '2022-09-21'),  " +
                "      ('15', '2','NV04', '2022-09-22'),  " +
                "      ('15', '3','NV06', '2022-09-22'),  " +
                "      ('15', '4','NV07', '2022-09-25'),  " +
                "      ('15', '5','NV07', '2022-09-25');";
        sqLiteDatabase.execSQL(taoLSDH);
        sqLiteDatabase.execSQL(nhapLSDH1);
        sqLiteDatabase.execSQL(nhapLSDH2);
        sqLiteDatabase.execSQL(nhapLSDH3);
        sqLiteDatabase.execSQL(nhapLSDH4);
        sqLiteDatabase.execSQL(nhapLSDH5);
        sqLiteDatabase.execSQL(nhapLSDH6);
        sqLiteDatabase.execSQL(nhapLSDH7);
        sqLiteDatabase.execSQL(nhapLSDH8);
        sqLiteDatabase.execSQL(nhapLSDH9);
        sqLiteDatabase.execSQL(nhapLSDH10);
        sqLiteDatabase.execSQL(nhapLSDH11);
        sqLiteDatabase.execSQL(nhapLSDH12);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "Drop table if exists tbLichsudh";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
