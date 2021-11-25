--use database dulu
delete from supplier;
delete from kategori;
delete from produk;
delete from supplied_product;
delete from jabatan;
delete from cabang;
delete from karyawan;
delete from customer_profile;
delete from customer_account;
delete from order_product;
delete from ordered_product;

insert into supplier (nama_supplier, alamat, nomor_hp, email, kode_pos) 
values ('Ahmad', 'Jalan Merdeka', '0871254562', 'ahmad@gmail.com', '9001');
insert into supplier (nama_supplier, alamat, nomor_hp, email, kode_pos) 
values ('Fadel', 'Jalan Tidak Merdeka', '08123645771', 'fadel@gmail.com', '9002');
insert into supplier (nama_supplier, alamat, nomor_hp, email, kode_pos) 
values ('Abyan', 'Jalan Kapan Merdeka', '0825184551', 'ahmad@gmail.com', '9003');
insert into supplier (nama_supplier, alamat, nomor_hp, email, kode_pos) 
values ('Fauzan', 'Jalan Sudah Mvalues erdeka', '0813254882', 'fauzan@gmail.com', '9004');
insert into supplier (nama_supplier, alamat, nomor_hp, email, kode_pos) 
values ('Hassan', 'Jalan Belum Merdeka', '036744125', 'hassan@gmail.com', '9005');

insert into kategori values ('buah', 'kategori yang berisi buah-buahan');
insert into kategori values ('sayur', 'kategori yang berisi sayur-sayuran');

insert into produk (nama_produk, jumlah_stok, harga_satuan, deskripsi, nutrition_facts, kategori) 
values ('Mangga', 40, 15000, 'mangga segar dan sehat', 'vitamin a', 'buah');
insert into produk (nama_produk, jumlah_stok, harga_satuan, deskripsi, nutrition_facts, kategori) 
values ('Pisang', 30, 10000, 'pisang segar dan sehat', 'vitamin a,b,c', 'buah');
insert into produk (nama_produk, jumlah_stok, harga_satuan, deskripsi, nutrition_facts, kategori) 
values ('Timun', 60, 7000, 'timun segar dan sehat', 'vitamin c,k', 'sayur');
insert into produk (nama_produk, jumlah_stok, harga_satuan, deskripsi, nutrition_facts, kategori) 
values ('Tomat', 50, 8000, 'tomat segar dan sehat', 'vitamin b,c', 'sayur');
insert into produk (nama_produk, jumlah_stok, harga_satuan, deskripsi, nutrition_facts, kategori) 
values ('Apel', 15, 30000, 'apel segar dan sehat', 'vitamin a,c,k', 'buah');

insert into supplied_product values (1, 1, 50);
insert into supplied_product values (2, 2, 25);
insert into supplied_product values (3, 3, 45);
insert into supplied_product values (4, 4, 10);
insert into supplied_product values (5, 5, 15);

insert into jabatan values ('Manager', 6000000);
insert into jabatan values ('Marketing', 4500000);
insert into jabatan values ('Kurir', 3000000);

insert into cabang (nama_cabang, alamat_cabang) values ('cabang malang', 'jalan veteran');
insert into cabang (nama_cabang, alamat_cabang) values ('cabang bali', 'jalan kuta');
insert into cabang (nama_cabang, alamat_cabang) values ('cabang jakarta', 'jalan kuningan');

insert into karyawan (nama, tanggal_lahir, nomor_hp, email, alamat, id_cabang, jabatan) 
values ('Faisal', '1998-08-14', '081745562', 'faisal@gmail.com', 'Jalan Sesetan', 1, 'Kurir');
insert into karyawan (nama, tanggal_lahir, nomor_hp, email, alamat, id_cabang, jabatan) 
values ('Hakim', '1997-12-05', '082546587', 'hakim@gmail.com', 'Jalan Pedungan', 1, 'Manager');
insert into karyawan (nama, tanggal_lahir, nomor_hp, email, alamat, id_cabang, jabatan) 
values ('Ridwan', '1997-02-11', '08695123', 'ridwan@gmail.com', 'Jalan Hautang', 2, 'Manager');
insert into karyawan (nama, tanggal_lahir, nomor_hp, email, alamat, id_cabang, jabatan) 
values ('Mahameruh', '1998-06-13', '08265781', 'mahameruh@gmail.com', 'Jalan Veteran', 3, 'Manager');
insert into karyawan (nama, tanggal_lahir, nomor_hp, email, alamat, id_cabang, jabatan) 
values ('Nisai', '1999-11-04', '0875422156', 'nisai@gmail.com', 'Jalan Merdeka', 3, 'Marketing');

insert into customer_profile  (nama_pelanggan, tanggal_lahir, nomor_hp, nomor_rumah, desa_kecamatan, kabupaten_kota, jalan, jenis_kelamin, kode_pos) 
values ('Victoria', '1913-04-02', '0526715754', 8, 'Batu', 'Malang', 'Gang Surapati', 'P', '81124');
insert into customer_profile  (nama_pelanggan, tanggal_lahir, nomor_hp, nomor_rumah, desa_kecamatan, kabupaten_kota, jalan, jenis_kelamin, kode_pos) 
values ('Paramita', '1920-12-15', '082608102', 99, 'Malang', 'Malang', 'Gang S. Parman', 'P', '51147');
insert into customer_profile  (nama_pelanggan, tanggal_lahir, nomor_hp, nomor_rumah, desa_kecamatan, kabupaten_kota, jalan, jenis_kelamin, kode_pos) 
values('Samsul', '1913-04-02', '0351367322', 2, 'Pedungan', 'Denpasar', 'Jl. Jamika', 'L', '80002');
insert into customer_profile  (nama_pelanggan, tanggal_lahir, nomor_hp, nomor_rumah, desa_kecamatan, kabupaten_kota, jalan, jenis_kelamin, kode_pos) 
values('Paiman', '1924-09-14', '0886705467', 8, 'Kuningan', 'Jakarta', 'Jl. Medokan Ayu', 'L', '25557');

insert into customer_account values (1, 'victoria@gmail.com', 'victoriapw');
insert into customer_account values (2 ,'paramita@gmail.com', 'paramitapw');
insert into customer_account values (3, 'samsul@gmail.com', 'samsulpw');
insert into customer_account values (4, 'paiman@gmail.com', 'paimanpw');

insert into order_product (tanggal_kirim, status_order, id_pelanggan, id_karyawan) 
values ('2021-05-11', 1, 1, 2)
insert into order_product (tanggal_kirim, status_order, id_pelanggan, id_karyawan)
values ('2021-06-12', 0, 2, 1)
insert into order_product (tanggal_kirim, status_order, id_pelanggan, id_karyawan) 
values ('2021-06-15', 0, 3, 3)
insert into order_product (tanggal_kirim, status_order, id_pelanggan, id_karyawan) 
values ('2021-06-15', 0, 3, 3)
insert into order_product (tanggal_kirim, status_order, id_pelanggan, id_karyawan) 
values ('2021-06-17', 0, 4, 4)

insert into ordered_product (order_id, product_id, kuantitas, harga_product)
values (1, 1, 3, 50000)
insert into ordered_product (order_id, product_id, kuantitas, harga_product)
values (2, 2, 9, 50000)
insert into ordered_product (order_id, product_id, kuantitas, harga_product)
values (3, 3, 10, 50000)
insert into ordered_product (order_id, product_id, kuantitas, harga_product)
values (4, 4, 5, 50000)
insert into ordered_product (order_id, product_id, kuantitas, harga_product)
values (4, 1, 2, 10000)
insert into ordered_product (order_id, product_id, kuantitas, harga_product)
values (3, 2, 11, 5000)

-- check semua tabel
select * from cabang
select * from customer_account
select * from customer_profile
select * from jabatan
select * from karyawan
select * from kategori
select * from order_product
select * from ordered_product
select * from produk
select * from supplied_product
select * from supplier

-- check view
select * from subtotal
select * from total