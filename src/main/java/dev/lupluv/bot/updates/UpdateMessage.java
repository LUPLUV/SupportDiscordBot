package dev.lupluv.bot.updates;

import dev.lupluv.bot.Bot;
import dev.lupluv.bot.utils.Util;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.NewsChannel;

import java.awt.*;

public class UpdateMessage {

    public static void sendUpdateMessage(Plugin plugin){
        if(plugin == Plugin.SIMPLE_GAMEMODE){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Simple Gamemode - " + SpigotMcChecker.getNewestVersion(plugin));
            eb.addField(SpigotMcChecker.getNewestUpdateTitle(plugin), SpigotMcChecker.getNewestUpdateDescription(plugin), true);
            eb.addField("Release", "https://github.com/LUPLUV/SimpleGamemode/releases/tag/" + SpigotMcChecker.getNewestVersion(plugin), true);
            eb.addField("SpigotMC", "https://www.spigotmc.org/resources/simple-gamemode-gm-1-8-1-19.86743/", true);
            eb.setColor(Color.YELLOW);
            eb.setFooter("lupluv.dev • " + Util.getDateFormatted(), Bot.jda.getSelfUser().getAvatarUrl());
            eb.setThumbnail("https://www.spigotmc.org/data/resource_icons/86/86743.jpg?1608031994");
            NewsChannel nc = Bot.jda.getGuildById("836262437920964668").getNewsChannels().get(0);
            assert nc != null;
            nc.sendMessage("**Update on SpigotMC.org " + nc.getGuild().getRoleById("1026190053204054067").getAsMention() + "**").addEmbeds(eb.build()).queue();
        }else if(plugin == Plugin.CRAFTATTACK8){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Craftattack8 - " + SpigotMcChecker.getNewestVersion(plugin));
            eb.addField(SpigotMcChecker.getNewestUpdateTitle(plugin), SpigotMcChecker.getNewestUpdateDescription(plugin), true);
            eb.addField("Release", "https://github.com/LUPLUV/Craftattack8/releases/tag/" + SpigotMcChecker.getNewestVersion(plugin), true);
            eb.addField("SpigotMC", "https://www.spigotmc.org/resources/»-craftattack-8-remake-«.91769/", true);
            eb.setColor(Color.YELLOW);
            eb.setFooter("lupluv.dev • " + Util.getDateFormatted(), Bot.jda.getSelfUser().getAvatarUrl());
            eb.setThumbnail("https://www.spigotmc.org/data/resource_icons/91/91769.jpg?1619506403");
            NewsChannel nc = Bot.jda.getGuildById("836262437920964668").getNewsChannels().get(0);
            assert nc != null;
            nc.sendMessage("**Update on SpigotMC.org " + nc.getGuild().getRoleById("1026190053204054067").getAsMention() + "**").addEmbeds(eb.build()).queue();
        }
    }

}
