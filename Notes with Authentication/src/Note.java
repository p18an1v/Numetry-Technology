class Note {
    private int id;
    private String combinedData;

    public Note(int id, String combinedData) {
        this.id = id;
        this.combinedData = combinedData;
    }

    public int getId() {
        return id;
    }

    public String getCombinedData() {
        return combinedData;
    }

    public void setCombinedData(String combinedData) {
        this.combinedData = combinedData;
    }
}
