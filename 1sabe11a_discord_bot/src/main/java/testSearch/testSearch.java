package testSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Search.Char_Search;
import Search.SearchTable;
import Search.charNameSearch;
import ServerAPI.ServerCode;
import ServerAPI.apiKey;

public class testSearch {
	
	Document dunoff_doc;
	Document dundamdoc;
	Document doctest;
	SearchTable searchTable;
	ServerCode serverCode = new ServerCode();
    apiKey apikey = new apiKey();
    charNameSearch search;
    String char_info;
    Char_Search char_Search;
    charNameSearch codeSearch;
    Scanner scan;
    
    String[] arr_data_value; // 데미지 증가량 배열
    // 이름
    String weapon_text; 
    String pants_text;
	String ring_text;
    String support_text;
    String style_text;
    String creature_text;
	// 데미지 증가량 
	String damage_upper;
    String critical_upper;
    String plus_upper;
    String all_damage;
    String con_damage;
    String stat_upper;
	private String skill_upper;
	private String allItem;
	private String shoulder_text;
	private String Item_img;
    
    public testSearch(String char_name, String servernum) throws IOException {
		codeSearch = new charNameSearch();
    	String dundam_url = "https://dundam.xyz/view40s?image=9fa771777e8e4ea350bb35c93478d18b&server=cain&name=%EB%98%A5%EC%A7%AC%EC%93%B0%EB%A0%88%EA%B8%B0&temp=840";
		String dunoff_url = "https://dunfaoff.com/SearchResult.df?server="+serverCode.selectServer(servernum)+"&characterid="+codeSearch.charNameSearch(char_name, servernum);
		
		try {
			searchTable = new SearchTable();
			dunoff_doc = Jsoup.connect(dunoff_url).get();
			Elements dunoff_data_item_value = dunoff_doc.select("#dmgIncrement");
			String data_value = dunoff_data_item_value.text();
			arr_data_value = data_value.split(" ");
			
			try {
				searchTable.setSSL();
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void getAll_arr() {
    	for (int i = 0; i < arr_data_value.length; i++) {
    		System.out.println(arr_data_value[i]+" " + i+"번");
		}
    
    }
    public String getGuild_name() {
		Elements dunoff_data_guild_value = dunoff_doc.select("#char_guild");
		String data_value = dunoff_data_guild_value.text();
		String data[] = data_value.split(" ");
		return data_value;
	}
	public String getDamage_upper() { 
		damage_upper = arr_data_value[3];// 뎀증
		return damage_upper;
	}
    public String getCritical_upper() {
    	critical_upper = arr_data_value[7]; // 크증
		return critical_upper;
	}
	public String getPlus_upper() {
		plus_upper = arr_data_value[30]; // 추뎀
		return plus_upper;
	}
	public String getAll_damage() {
		all_damage = arr_data_value[18]; // 모공
		return all_damage;
	}
	public String getCon_damage() {
		con_damage = arr_data_value[22]; // 물마독공
		return con_damage;
	}
	public String getStat_upper() {
		stat_upper = arr_data_value[10]; // 스탯
		return stat_upper;
	}
	public String getSkill_upper() {
		skill_upper = arr_data_value[14];
		return skill_upper;
	}
	public String getItem_text() {
//		for (int i = 0; i < 14; i++) {
//			Element dunoff_Item_all_name = dunoff_doc.select(".itemRows a.tvitemName").get(i);
//			allItem = dunoff_Item_all_name.text();
//			System.out.println(allItem);
//		}
		Elements dunoff_Item_img = dunoff_doc.select("#equipTable .itemimg");
//		List<String> imageUrls = new ArrayList<>();
//		for (Element img : dunoff_Item_img) {
//			imageUrls.add(img.attr("src"));
//			
//		}
		String img_src = dunoff_Item_img.get(13).attr("src");
		return img_src;
	}
	public String getWeapon_text() {
		Element dunoff_weapon_item_name = dunoff_doc.select(".itemRows a.tvitemName").get(0); // 무기 이름
		weapon_text = dunoff_weapon_item_name.text();
		return weapon_text;
	}
	public String getShoulder_text() {
		Element dunoff_Shoulder_item_name = dunoff_doc.select(".itemRows a.tvitemName").get(1);
		shoulder_text = dunoff_Shoulder_item_name.text();
		return shoulder_text;
	}
    public String getPants_text() {
		Element dunoff_pants_item_name = dunoff_doc.select(".itemRows a.tvitemName").get(3); // 바지 이름
		pants_text = dunoff_pants_item_name.text();
		return pants_text;
	}
	public String getRing_text() {
		Element dunoff_ring_item_name = dunoff_doc.select(".itemRows a.tvitemName").get(8);  // 반지 이름
		ring_text = dunoff_ring_item_name.text();
		return ring_text;
	}
	public String getSupport_text() {
		Element dunoff_support_item_name = dunoff_doc.select(".itemRows a.tvitemName").get(9); // 보조장비 이름
		support_text = dunoff_support_item_name.text();
		return support_text;
	}
	public String getStyle_text() {
		Element dunoff_style_item_name = dunoff_doc.select(".itemRows a.tvitemName").get(12); //칭호 이름
		style_text = dunoff_style_item_name.text();
		return style_text;
	}
	public String getCreature_text() {
		Element dunoff_creature_item_name = dunoff_doc.select(".itemRows a.tvitemName").get(13); //크리처 이름
		creature_text = dunoff_creature_item_name.text();
		return creature_text;
	}
	
	public void radio() {
//		String result = "정보\n뎀증: "+getDamage_upper()+"\n크증: "+getCritical_upper()+"\n추뎀: "
//		+getPlus_upper()+"\n모공: "+getAll_damage()+"\n물마독: "+getCon_damage()+"\n힘지능: "+getStat_upper()+"\n무기: "+getWeapon_text()+"\n바지: "+getPants_text()+"\n반지: "
//		+getRing_text()+"\n보조장비: "+getSupport_text()+"\n칭호: "+getStyle_text()+"\n크리처: "+getCreature_text();
//		return result;
		System.out.println(getWeapon_text()+"\n"+getShoulder_text());
	}
	public void excel_selector() {
		try {
			FileInputStream is = new FileInputStream("C:\\data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows(); // 행의 길이 측정
			for (int i = 0; i < rows; i++) {
				XSSFRow row = sheet.getRow(i);		
					if(row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for(short c = 0; c < cells-1; c++) {
						XSSFCell cell = row.getCell(c);
						if(cell != null) {
							String value = null;
							switch(cell.getCellType()){
								case FORMULA:
									value = "FORMULA value="+cell.getCellFormula();
									break;
								case NUMERIC:
									value = "NUMERIC value="+cell.getNumericCellValue();
									break;
								case STRING:
									value = "장비 이름: "+cell.getStringCellValue();
									break;
								case BLANK:
									value = null;
									break;
								case BOOLEAN:
									value = "BOOLEAN value="+cell.getBooleanCellValue();
									break;
								case ERROR:
									value = "ERROR value="+cell.getErrorCellValue();
									break;
							default:
								break;
							}
							System.out.print(value);
						}
						System.out.println("");
						}
					}
				}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}
	public void doctest() {
		String url = "https://finance.naver.com/sise/sise_index.nhn?code=KOSPI";
		try {
			doctest = Jsoup.connect(url).get();
			Elements teststr = doctest.select("#now_value");
			String datatext = teststr.text();
			System.out.println("코스피 :" +datatext);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		testSearch test = new testSearch("부양딸내미", "카인");
		System.out.println(test.getItem_text());
//		testSearch testsearch = new testSearch("똥짬쓰레기",0);
//		System.out.println(testsearch.radio());
//		testsearch.excel_selector();
	}
}
