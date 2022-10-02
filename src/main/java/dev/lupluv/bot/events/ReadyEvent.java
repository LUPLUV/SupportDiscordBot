package dev.lupluv.bot.events;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyEvent extends ListenerAdapter {

    @Override
    public void onReady(net.dv8tion.jda.api.events.ReadyEvent e){
        System.out.println("API is ready!");
    }

}
