public class VideoVerleih
{
    public static void main ( String args[] )
    {
        TechnikReportage tReportagen [] = new TechnikReportage[5];
        tReportagen[0] = new TechnikReportage("Der Fall Boeing", 70, "10.06.2014", "Flugzeuge");
        tReportagen[1] = new TechnikReportage("Der Tesla-Mythos", 85, "22.08.2017", "Elektroautos");
        tReportagen[2] = new TechnikReportage("Das Geheimnis der Quantencomputer", 95, "15.11.2020", "Computer");
        tReportagen[3] = new TechnikReportage("Die Wiedergeburt der Raumfahrt", 78, "04.07.2019", "Raumfahrt");
        tReportagen[4] = new TechnikReportage("Künstliche Intelligenz: Fluch oder Segen?", 90, "12.03.2022", "KI-Technologie");

        for (TechnikReportage tRep : tReportagen) {
            tRep.anzeigen();
        }
    }
}