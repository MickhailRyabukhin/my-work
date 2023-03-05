public class Printer {

    private String queue = "";
    private int pendingPagesCount = 0;
    private int totalPagesPrinted = 0;

    public void append (String docText){
        append(docText,"unnounDoc",1);
    }

    public void append (String docText,String docName){
         append(docText,docName,1);
    }


    public void append (String docText,String docName, int docPagesCount){
        queue = queue +" \n" + docName + "  " + docPagesCount +"  " + docText;
        pendingPagesCount = pendingPagesCount + docPagesCount;
    }

    public void clear() {
        queue = "";
        pendingPagesCount = 0;
    }

    public int getPendingPagesCount() {
      return pendingPagesCount;
    }

    public int getTotalPagesPrinted (){
        return totalPagesPrinted;
    }

    public void print() {
        System.out.println("Документы в очереди на печать");
        if (queue.isEmpty()) {
            System.out.println("Очередь печати пуста");
        } else {
            System.out.println(queue);
            totalPagesPrinted =totalPagesPrinted +pendingPagesCount;
            clear();
        }
    }

}
