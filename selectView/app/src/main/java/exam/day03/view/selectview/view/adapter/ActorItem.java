package exam.day03.view.selectview.view.adapter;

public class ActorItem {
    int myImg;
    String name;
    String date;
    String text;

    public ActorItem(int myImg, String name, String date, String text) {
        this.myImg = myImg;
        this.name = name;
        this.date = date;
        this.text = text;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "myImg=" + myImg +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
