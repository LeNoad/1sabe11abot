package Main;

import java.io.IOException;
import java.lang.module.ModuleDescriptor.Builder;

import javax.security.auth.login.LoginException;

import Command.char_Search_Command;
import Search.Char_Search;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {
	public static void main(String[] args) {
		JDABuilder builder = JDABuilder.createDefault(""); // 네오플 API 토큰값
        JDA jda;
        builder.addEventListeners(new char_Search_Command());
        try {
            jda = builder.build();

        } catch (LoginException e) {
            e.printStackTrace();
        }
	}
}
