package TextFormatting;

public class Addbold extends TextDecorator{
    public Addbold(Text text){
        super(text);
    }
    @Override
    public String getContent(){
        return "<bold>" + text.getContent() + "</bold>";
    }
}
