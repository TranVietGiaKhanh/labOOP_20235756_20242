package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MediaStore extends JPanel{
	private Media media;

    public MediaStore(Media media) {
        this.media = media;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                ((Playable) media).play();
                JOptionPane.showMessageDialog(this, "Played: " + media.getTitle());
            });
            container.add(playButton);
        }

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(Box.createVerticalGlue());
        add(container);

        setBorder(new LineBorder(Color.BLACK));
    }
}
