package dev.lupluv.bot;

import dev.lupluv.bot.files.FileManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import dev.lupluv.bot.events.*;

import javax.security.auth.login.LoginException;

public class Bot {

    public static Bot bot;
    public static JDA jda;

    public Bot() throws LoginException {
        bot = this;
        FileManager.loadFiles();
        JDABuilder jdaBuilder = JDABuilder.create(FileManager.getConfig().getString("Token"), GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_BANS, GatewayIntent.GUILD_INVITES
                , GatewayIntent.DIRECT_MESSAGE_REACTIONS, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES
                , GatewayIntent.GUILD_EMOJIS_AND_STICKERS, GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_WEBHOOKS
                , GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.GUILD_MESSAGE_REACTIONS);
        jdaBuilder.setActivity(Activity.playing("lupluv.dev"));
        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        jdaBuilder.addEventListeners(new ReadyEvent(), new MessageReceivedEvent(), new SlashCommandInteractionEvent());
        jda = jdaBuilder.build();
        jda.updateCommands().addCommands(
                Commands.slash("update", "Send update message of a plugin.")
                        .addOption(OptionType.STRING, "name", "The plugin name.", true),
                Commands.slash("ping", "Calculate ping of the Bot")
        ).queue();
    }

    public static void main(String[] args){
        try {
            new Bot();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
