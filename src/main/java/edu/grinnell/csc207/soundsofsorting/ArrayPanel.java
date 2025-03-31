package edu.grinnell.csc207.soundsofsorting;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Color;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
    private int width;
    private int height;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * 
     * @param notes  the note indices
     * @param width  the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
    }

    public int MaxIndexValue(Integer[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.width, this.height);
        Integer[] noteIndices = notes.getNotes();
        int maxIndexValue = MaxIndexValue(noteIndices);

        int barWidth = width / noteIndices.length;
        int barHeight;
        int barProp = this.height / maxIndexValue;

        for (int i = 0; i < noteIndices.length; i++) {
            /*
             * System.out.println("Indices length: " + noteIndices.length);
             * System.out.println("barWidth: " + barWidth);
             * System.out.println("i: " + i);
             * System.out.println("End condition: " + noteIndices.length * barWidth);
             */
            barHeight = barProp * noteIndices[i] + barProp;
            Color c = new Color(barHeight / 2, 20, 20);
            g.setColor(c);
            g.fillRect(i * barWidth, this.height - barHeight, barWidth, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(i * barWidth, this.height - barHeight, barWidth, barHeight);
        }
        return;
    }
}