package chatapp.chitchat.com.chitchat;

public class ChatRow {
    private String name,lastMessage,time;
    int imageId;
    public ChatRow(){
    }

    public ChatRow(String name, String lastMessage,String time,int imageId){
        this.name = name;
        this.lastMessage = lastMessage;
        this.time = time;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
