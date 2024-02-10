package org.campus;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.List;

public class Main {
    public static final String BOT_TOKEN = "6905657510:AAH_te9xtN_Ec23e_3AgF2a_MYII1OOV9gI";
    public static void main(String[] args) {
        System.out.println("Привет мир!");

        TelegramBot telegramBot = new TelegramBot(BOT_TOKEN);
        telegramBot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> list) {
                for (Update update: list){
                    SendMessage sendMessage = new SendMessage(update.message().from().id(), "Привет Мир!");
                    telegramBot.execute(sendMessage);
                }

                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
    }
}