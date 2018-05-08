/*
 * http://www.runoob.com/design-pattern/adapter-pattern.html
 * 适配器模式是作为两个不兼容的接口之间的桥梁
 * 这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能
 * 这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能
 * 举个真实的例子：读卡器作为内存卡和笔记本之间的适配器
 * 您将内存卡插入读卡器，再将读卡器插入笔记本，这样就可以通过笔记本来读取内存卡
 */

// 为媒体播放器和更高级的媒体播放器创建接口
public interface MediaPlayer{
    public void play(String audioType, String fileName);
}

public interface AdvancedMediaPlayer{
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}


// 创建实现了AdvancedMediaPlayer接口的实体类
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName){
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName){
        //do nothing
    }
}

public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName){
        //do nothing
    }

    @Override
    public void playMp4(String fileName){
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}


// 创建实现了MediaPlayer接口的适配器类
public class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaPlayer(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer = new VlcPlayer();
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}


// 创建实现了MediaPlayer接口的实体类
public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaPlayer;

    @Override
    public void play(String audioType, String fileName){
        // 播放mp3音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // mediaAdapter 提供了播放其他文件格式的支持
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
    }
}


// 使用AudioPlayer来播放不同类型的音频格式
public class AdapterPatternDemo{
    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "hello.mp3");
        audioPlayer.play("mp4", "just beat it.mp4");
        audioPlayer.play("vlc", "byebye.vlc");
    }
}
