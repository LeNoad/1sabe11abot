package Command;

import java.awt.Color;
import java.io.IOException;

import Search.Char_Search;
import Search.SearchTable;
import Search.charNameSearch;
import ServerAPI.ServerCode;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import testSearch.testSearch;

public class char_Search_Command extends ListenerAdapter {
    SearchTable searchTable;
    charNameSearch charName;
    public void onMessageReceived(MessageReceivedEvent event){
        User user = event.getAuthor();
        TextChannel tc = event.getTextChannel();
        Message msg = event.getMessage();
        EmbedBuilder eb = new EmbedBuilder();
        ServerCode serverCode = new ServerCode();
        testSearch testsearch;
        if(user.isBot()) return;
        System.out.println(msg.getContentRaw());
        if(msg.getContentRaw().charAt(0) == '#'){
            String[] args = msg.getContentRaw().substring(1).split(" ");
            for(String s : args){
                System.out.println(s);
            }
            if(args.length <= 0)
                return;
            if(args[0].equalsIgnoreCase(args[0])) {
                if (args.length < 2)
                    return;
                if (args[1].equalsIgnoreCase(args[1])) {
                    try {
//                        String rs = charName.charNameSearch(args[0],Integer.parseInt(args[1]));
                        charName = new charNameSearch();
                        searchTable = new SearchTable();
                        searchTable.search(args[0],args[1]);
//                        testsearch = new testSearch(args[0],Integer.parseInt(args[1]));
//                        tc.sendMessage(testsearch.radio()).queue();  //무기정보
                        try{
                            if(searchTable.getBuffTable(39).equals("라우스") || searchTable.getBuffTable(39).equals("최후의")){
                                eb.setTitle("眞:크루세이더("+args[0]+")",searchTable.getThumbnail_URL())
                                    .addField("종합 (2각)", searchTable.getBuffTable(48) + " "+searchTable.getBuffTable(49), true)
                                    .addField("총버프", searchTable.getBuffTable(58), true)
//                                    .addField("랭킹",searchTable.getRankTable(7),false) 랭킹
                                    .setColor(Color.GREEN);
                            } else {
                                eb.setTitle("眞:헤카테("+args[0]+")",searchTable.getThumbnail_URL())
                                	.addField("종합 (편애)", searchTable.getBuffTable(39) + " " + searchTable.getBuffTable(40), true)
                                    .addField("총버프(편애)", searchTable.getBuffTable(51) + " " +searchTable.getBuffTable(50), true)
//                                    .addField("랭킹",searchTable.getRankTable(7),false) 랭킹
                                    .setColor(Color.PINK);
                            }
                        } catch(ArrayIndexOutOfBoundsException e){
                            eb.setTitle("시로코 1시 기준("+args[0]+")",searchTable.getThumbnail_URL())
//                                    .addField("랭킹",searchTable.getRankTable(3),true)
                            		.addField("시로코1시 25초x",searchTable.get1sinergeDmgTable(13),true)
                                    .addField("시로코1시 25초",searchTable.get1sinergeDmgTable(9),true)
                                    .setColor(Color.BLUE);
                        }
                        eb.setImage("https://img-api.neople.co.kr/df/servers/"+serverCode.selectServer(args[1])+
                                "/characters/"+charName.charNameSearch(args[0],args[1])+"?zoom=0").addBlankField(true);
                        event.getChannel().sendMessage(eb.build()).queue();
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(msg.getContentRaw().charAt(0) == '!') {
        	String[] args = msg.getContentRaw().substring(1).split(" ");
        	if(args.length<=0)
        		return;
        	
        	if(args[0].equalsIgnoreCase("사용법")) {
        		eb.setTitle("사용법").addField("서버 번호","0번 : 카인\n1번 : 디레지에\n2번 : 시로코\n3번 : 프레이\n4번 : 카시야스\n5번 : 힐더\n6번 : 안톤\n7번 : 바칼",true).addField("EX)","#부양딸내미 0",false);
        		event.getChannel().sendMessage(eb.build()).queue();
        	}
        }
    }
}
