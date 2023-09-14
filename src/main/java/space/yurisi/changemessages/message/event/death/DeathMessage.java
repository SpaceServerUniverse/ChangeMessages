package space.yurisi.changemessages.message.event.death;

import net.kyori.adventure.text.Component;

import java.util.Random;

public class DeathMessage {

    protected Component[] messages;

    private int getRandom(Component[] components){
        Random rnd = new Random();
        return rnd.nextInt(components.length);
    }

    public Component getMessage() {
        int i = this.getRandom(messages);
        return messages[i];
    }
}
