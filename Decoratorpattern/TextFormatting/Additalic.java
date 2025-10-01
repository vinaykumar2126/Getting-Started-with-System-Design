package TextFormatting;

public class Additalic extends TextDecorator{
    public Additalic(Text text){
        super(text);
    }
    @Override
    public String getContent(){
        return "<italic>" + text.getContent() + "</italic>";
    }
}
