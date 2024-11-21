public class TechnikReportage extends Reportage {
    String topicArea;

    public TechnikReportage(String ttl, String releaseDate, String topicArea) {
        super(ttl, releaseDate);
        this.topicArea = topicArea;
    }

    public TechnikReportage(String ttl, int duration, String releaseDate, String topicArea) {
        super(ttl, duration, releaseDate);
        this.topicArea = topicArea;
    }

    public void anzeigen(){
        super.anzeigen();
        System.out.println("Topic Area: " + topicArea);
    }
}
