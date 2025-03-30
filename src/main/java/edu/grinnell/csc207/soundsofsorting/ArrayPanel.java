package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

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
     * @param notes the note indices 
     * @param width the width of the panel
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

        for(int i = 0; i < noteIndices.length * barWidth; i += barWidth) {
            barHeight = this.height / (maxIndexValue - noteIndices[i]);
            g.drawRect(i, 0, barWidth, barHeight);
        }
    }
}