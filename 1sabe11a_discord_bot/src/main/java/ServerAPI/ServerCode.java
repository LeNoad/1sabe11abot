package ServerAPI;

public class ServerCode {
    private String[] server = {"cain","diregie","siroco","prey","casillas","hilder","anton","bakal"};
    private String[] not_server = {"카인", "디레지에", "시로코", "프레이", "카시야스", "힐더", "안톤", "바칼"};
    public String selectServer(String select){
    	String api_Servername = null;
		switch(select){
			case "카인":
				api_Servername = server[0];
				break;
			case "디레지에":
				api_Servername = server[1];
				break;
			case "시로코":
				api_Servername = server[2];
				break;
			case "프레이":
				api_Servername = server[3];
				break;
			case "카시야스":
				api_Servername = server[4];
				break;
			case "힐더":
				api_Servername = server[5];
				break;
			case "안톤":
				api_Servername = server[6];
				break;
			case "바칼":
				api_Servername = server[7];
				break;
		}		
    	return api_Servername;
    }
}