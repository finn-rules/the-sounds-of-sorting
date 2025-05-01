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

    /**
     * Find the maximum value in an array of integers.
     * 
     * @param arr an array of integers
     * @return the maximum value in this array
     */
    public int maxIndexValue(Integer[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * paintComponent : paints the panel, and note bars.
     * 
     * @param g the graphics panel
     */
    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.width, this.height);
        Integer[] noteIndices = notes.getNotes();
        int maxIndexValue = maxIndexValue(noteIndices);

        int barWidth = width / noteIndices.length;
        int barHeight;
        int barProp = this.height / maxIndexValue;

        for (int i = 0; i < noteIndices.length; i++) {
            barHeight = barProp * noteIndices[i] + barProp;
            Color c = new Color(barHeight / 2, 20, 20);
            if (notes.isHighlighted(i)) {
                c = new Color(0, 0, 150);
            }
            g.setColor(c);
            g.fillRect(i * barWidth, this.height - barHeight, barWidth, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(i * barWidth, this.height - barHeight, barWidth, barHeight);
        }
        notes.clearAllHighlighted();
        return;
    }
}