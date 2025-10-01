package TextFormatting;

public class Main {
    public static void main(String args[]){
        Text text = new DefaultText();
        Text bold = new Addbold(text);
        Text italic = new Additalic(text);

        System.out.println(bold.getContent());
        System.out.println(italic.getContent());
    }
    
}
