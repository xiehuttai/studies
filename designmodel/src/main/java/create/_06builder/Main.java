package create._06builder;

/**
 * builder模式，构建复杂对象，构建过程可控
 */
public class Main {

    public static void main(String[] args) {

        PlayerBuilder normalPlayerBuilder = new NormalPlayerBuilder();
        Player normalPlayer = PlayerDirector.build(normalPlayerBuilder);
        normalPlayer.play();
        EasyPlayerBuilder easyPlayerBuilder = new EasyPlayerBuilder();
        Player easyPlayer = PlayerDirector.build(easyPlayerBuilder);
        easyPlayer.play();

    }

}

class Player{

    String  order;

    String window;

    String control;

    String fav;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public void play(){
        System.out.println(order
                +","+control
                +","+window
                +","+fav
        );
    }
}

abstract class PlayerBuilder{

    Player player= new Player();

    public abstract void setOrder() ;

    public abstract void setWindow() ;

    public abstract void setControl() ;

    public  abstract void setFav();

    public abstract boolean easy();

    public Player getPlayer(){
        return player;
    }

}

class NormalPlayerBuilder extends PlayerBuilder{

    @Override
    public void setOrder() {
        player.setOrder("normal order");
    }

    @Override
    public void setWindow() {
        player.setWindow("normal window");
    }

    @Override
    public void setControl() {
        player.setControl("normal control");
    }

    @Override
    public void setFav() {
        player.setFav("normal fav");
    }

    @Override
    public boolean easy() {
        return false;
    }
}


class EasyPlayerBuilder extends PlayerBuilder{

    @Override
    public void setOrder() {
        player.setOrder("easy order");
    }

    @Override
    public void setWindow() {
        player.setWindow("easy window");
    }

    @Override
    public void setControl() {
        player.setControl("easy control");
    }

    @Override
    public void setFav() {
        player.setFav("easy fav");
    }
    @Override
    public boolean easy() {
        return true;
    }
}


class PlayerDirector{
    public static  Player  build(PlayerBuilder builder){
        Player player;
        builder.setWindow();
        builder.setControl();
        if (!builder.easy()){
            builder.setOrder();
            builder.setFav();
        }
        player=builder.getPlayer();
        return player;
    }

}