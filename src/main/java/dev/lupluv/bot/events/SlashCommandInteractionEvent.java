package dev.lupluv.bot.events;

import dev.lupluv.bot.updates.Plugin;
import dev.lupluv.bot.updates.UpdateMessage;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;

public class SlashCommandInteractionEvent extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent e)
    {
        Member m = e.getMember();
        e.deferReply(true).queue();
        InteractionHook hook = e.getHook();
        if (e.getName().equals("ping")) {
            long time = System.currentTimeMillis();
            hook.setEphemeral(true).editOriginalFormat("Pong!") // reply or acknowledge
                    .flatMap(v ->
                            hook.editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time) // then edit original
                    ).queue(); // Queue both reply and edit
        }else if(e.getName().equals("update")){
            if(e.getOption("name").getAsString().equalsIgnoreCase("simplegamemode")){
                UpdateMessage.sendUpdateMessage(Plugin.SIMPLE_GAMEMODE);
                hook.setEphemeral(true).editOriginalFormat("Sent message :D").queue();
            }
        }
    }

}
