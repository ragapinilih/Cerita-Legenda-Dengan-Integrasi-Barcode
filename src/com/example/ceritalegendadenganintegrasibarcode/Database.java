package com.example.ceritalegendadenganintegrasibarcode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "cerita_database";
	private static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_CERITA = "cerita_table";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_JUDUL = "judul";
	public static final String COLUMN_CERITA = "cerita";
	public static final String COLUMN_BARCODE = "barcode";
	public static final String COLUMN_GAMBAR = "gambar";
	public static final String[] ALL_COLUMN ={COLUMN_ID, COLUMN_JUDUL, COLUMN_CERITA, COLUMN_BARCODE, COLUMN_GAMBAR};

	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	private static final String SQL_DATABASE_CREATE = "CREATE TABLE " +TABLE_CERITA+"(" +COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +COLUMN_JUDUL+ " TEXT, " +COLUMN_CERITA+ " TEXT, "+ COLUMN_BARCODE +" INTEGER, "+COLUMN_GAMBAR+" TEXT)";
	private static final String SQL_DATABASE_DROP ="DROP TABLE IF EXISTS "+TABLE_CERITA;
		
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_DATABASE_DROP);
		db.execSQL(SQL_DATABASE_CREATE);
		db.execSQL("INSERT INTO "+TABLE_CERITA+"("+COLUMN_JUDUL+", "+COLUMN_CERITA+", "+COLUMN_BARCODE+", "+COLUMN_GAMBAR+") VALUES('Sangkuriang', 'Pada jaman dahulu, tersebutlah kisah seorang puteri raja di Jawa Barat bernama Dayang Sumbi.Ia mempunyai seorang anak laki-laki yang diberi nama Sangkuriang. Anak tersebut sangat gemar berburu.Ia berburu dengan ditemani oleh Tumang, anjing kesayangan istana. Sangkuriang tidak tahu, bahwa anjing itu adalah titisan dewa dan juga bapaknya.Pada suatu hari Tumang tidak mau mengikuti perintahnya untuk mengejar hewan buruan. Maka anjing tersebut diusirnya ke dalam hutan.Ketika kembali ke istana, Sangkuriang menceritakan kejadian itu pada ibunya. Bukan main marahnya Dayang Sumbi begitu mendengar cerita itu. Tanpa sengaja ia memukul kepala Sangkuriang dengan sendok nasi yang dipegangnya. Sangkuriang terluka. Ia sangat kecewa dan pergi mengembara. Setelah kejadian itu, Dayang Sumbi sangat menyesali dirinya. Ia selalu berdoa dan sangat tekun bertapa. Pada suatu ketika, para dewa memberinya sebuah hadiah. Ia akan selamanya muda dan memiliki kecantikan abadi.Setelah bertahun-tahun mengembara, Sangkuriang akhirnya berniat untuk kembali ke tanah airnya. Sesampainya disana, kerajaan itu sudah berubah total. Disana dijumpainya seorang gadis jelita, yang tak lain adalah Dayang Sumbi. Terpesona oleh kecantikan wanita tersebut maka, Sangkuriang melamarnya. Oleh karena pemuda itu sangat tampan, Dayang Sumbi pun sangat terpesona padanya.Pada suatu hari Sangkuriang minta pamit untuk berburu. Ia minta tolong Dayang Sumbi untuk merapikan ikat kepalanya. Alangkah terkejutnya Dayang Sumbi demi melihat bekas luka di kepala calon suaminya. Luka itu persis seperti luka anaknya yang telah pergi merantau. Setelah lama diperhatikannya, ternyata wajah pemuda itu sangat mirip dengan wajah anaknya. Ia menjadi sangat ketakutan.Maka kemudian ia mencari daya upaya untuk menggagalkan proses peminangan itu. Ia mengajukan dua buah syarat. Pertama, ia meminta pemuda itu untuk membendung sungai Citarum. Dan kedua, ia minta Sangkuriang untuk membuat sebuah sampan besar untuk menyeberang sungai itu. Kedua syarat itu harus sudah dipenuhi sebelum fajar menyingsing.Malam itu Sangkuriang melakukan tapa. Dengan kesaktiannya ia mengerahkan mahluk-mahluk gaib untuk membantu menyelesaikan pekerjaan itu. Dayang Sumbi pun diam-diam mengintip pekerjaan tersebut. Begitu pekerjaan itu hampir selesai, Dayang Sumbi memerintahkan pasukannya untuk menggelar kain sutra merah di sebelah timur kota.Ketika menyaksikan warna memerah di timur kota, Sangkuriang mengira hari sudah menjelang pagi. Ia pun menghentikan pekerjaannya. Ia sangat marah oleh karena itu berarti ia tidak dapat memenuhi syarat yang diminta Dayang Sumbi.Dengan kekuatannya, ia menjebol bendungan yang dibuatnya. Terjadilah banjir besar melanda seluruh kota. Ia pun kemudian menendang sampan besar yang dibuatnya. Sampan itu melayang dan jatuh menjadi sebuah gunung yang bernama \"Tangkuban Perahu.\"', '8999909096004' ,'sangkuriang');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_DATABASE_DROP);
		onCreate(db);		
	}

}
