package Abstractions;

import ChooseDestination.MapPage;
import InformationSection.AirplaneSeatType;
import PathDatabase.Path;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.List;

public class PageLoader extends JFrame {
    private static volatile PageLoader instance = new PageLoader(430, 990);
    public JScrollPane contentPane;
    public MapPage mapPage;
    public static synchronized PageLoader getInstance() {
        return instance;
    }
    private PageLoader(int width, int height){
        // sets the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width + 20, height);
        this.setLayout(null);
        this.setResizable(true);
        this.setVisible(true);
        this.setLayout(null);
        // adds the components to the frame
        mapPage = new MapPage();
        mapPage.setPreferredSize(new Dimension(430, 990));
        // add
        contentPane = new JScrollPane(mapPage);
        contentPane.setBounds(-10, 0, width, height);
        contentPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        customizeVerticalScrollBar(contentPane);

        this.setContentPane(contentPane);
    }
    public void changeToSeatTypePage(List<Path> paths){
        contentPane.setViewportView(new AirplaneSeatType(paths));
        contentPane.repaint();
        this.revalidate();
    }

    public void changeToMapPage(){
        contentPane.setViewportView(mapPage);
        mapPage.resize();
        this.revalidate();
    }

    private static void customizeVerticalScrollBar(JScrollPane scrollPane) {
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();

        // Remove the default UI
        verticalScrollBar.setUI(new BasicScrollBarUI());

        // Customize the appearance
        verticalScrollBar.setBackground(Color.WHITE);
        verticalScrollBar.setForeground(new Color(187, 187, 187, 184));
        verticalScrollBar.setPreferredSize(new Dimension(7, Integer.MAX_VALUE));
        verticalScrollBar.setUnitIncrement(16); // Set the amount to scroll by with the arrow buttons
        verticalScrollBar.setBlockIncrement(32); // Set the amount to scroll by with the track

        // Add your own listeners or further customization as needed
    }
}
