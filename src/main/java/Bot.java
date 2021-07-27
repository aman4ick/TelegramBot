import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }


    public void sendMsg (Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try{
            setButtons(sendMessage);
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message message =  update.getMessage();
        int a = 420;

        if (message !=null && message.hasText()) {
            switch (message.getText()) {

                case "/start":
                    sendMsg(message, "выберите Валюту ");
                    break;

                case "/USD":
                    sendMsg(message, "Изменения курса валют USD за 10 дней ");
                    sendMsg(message, "27.07.2021 курс USD-424.60");
                    sendMsg(message, "26.07.2021 курс USD-424.68");
                    sendMsg(message, "25.07.2021 курс USD-424.68");
                    sendMsg(message, "24.07.2021 курс USD-424.68");
                    sendMsg(message, "23.07.2021 курс USD-425.71");
                    sendMsg(message, "22.07.2021 курс USD-428.52");
                    sendMsg(message, "21.07.2021 курс USD-427.19");
                    sendMsg(message, "20.07.2021 курс USD-427.19");
                    sendMsg(message, "19.07.2021 курс USD-426.47");
                    sendMsg(message, "18.07.2021 курс USD-426.47");
                    break;

                case "/EUR":
                    sendMsg(message, "Изменения курса валют EUR за 10 дней ");
                    sendMsg(message, "27.07.2021 курс EUR-500.90");
                    sendMsg(message, "26.07.2021 курс EUR-499.76");
                    sendMsg(message, "25.07.2021 курс EUR-499.76");
                    sendMsg(message, "24.07.2021 курс EUR-499.76");
                    sendMsg(message, "23.07.2021 курс EUR-502,08");
                    sendMsg(message, "22.07.2021 курс EUR-504,50");
                    sendMsg(message, "21.07.2021 курс EUR-503,14");
                    sendMsg(message, "20.07.2021 курс EUR-503,14");
                    sendMsg(message, "19.07.2021 курс EUR-504,04");
                    sendMsg(message, "18.07.2021 курс EUR-504,04");
                    break;

                case "/RUB":
                    sendMsg(message, "Изменения курса валют RUB за 10 дней ");
                    sendMsg(message, "27.07.2021 курс RUB-74,09");
                    sendMsg(message, "24.07.2021 курс RUB-73,76");
                    sendMsg(message, "23.07.2021 курс RUB-73,69");
                    sendMsg(message, "22.07.2021 курс RUB-74,49");
                    sendMsg(message, "21.07.2021 курс RUB-74,49");
                    sendMsg(message, "20.07.2021 курс RUB-74,34");
                    sendMsg(message, "17.07.2021 курс RUB-74,16");
                    sendMsg(message, "16.07.2021 курс RUB-74,21");
                    sendMsg(message, "15.07.2021 курс RUB-74,12");
                    sendMsg(message, "14.07.2021 курс RUB-74,05");
                    break;

                default:

            }
        }

    }

    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/USD"));
        keyboardFirstRow.add(new KeyboardButton("/RUB"));
        keyboardFirstRow.add(new KeyboardButton("/EUR"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);



    }

    public String getBotUsername() {
        return "MyExchangeBot";
    }

    public String getBotToken() {
        return "1929223833:AAEvW6nLQ1wd-lOOZDG-SnEOhGKvUZT_k18";
    }
}
