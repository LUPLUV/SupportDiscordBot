package dev.lupluv.bot.events;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceivedEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(net.dv8tion.jda.api.events.message.MessageReceivedEvent e)
    {
        if (e.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", e.getAuthor().getAsTag(),
                    e.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", e.getGuild().getName(),
                    e.getChannel().getName(), e.getAuthor().getAsTag(),
                    e.getMessage().getContentDisplay());
        }
    }

}
