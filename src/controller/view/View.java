package controller.view;

import java.awt.event.ActionListener;
import javax.swing.SpinnerNumberModel;

import controller.view.button.Button;
import controller.view.editabletextarea.EditableTextArea;
import controller.view.frame.Frame;
import controller.view.horizontalpanel.HorizontalPanel;
import controller.view.label.Label;
import controller.view.menubar.MenuBar;
import controller.view.scrollpanel.ScrollPanel;
import controller.view.spinner.Spinner;
import controller.view.uneditabletextarea.UneditableTextArea;

public final class View 
{
    private final Spinner keySpinner;
    private final EditableTextArea inputEditableTextArea;
    private final UneditableTextArea outputUneditableTextArea;

    public View(final ActionListener onEncryptButtonClickedActionListenerParameter, final ActionListener onDecryptButtonClickedActionListenerParameter, final ActionListener onBruteForceAttackButtonClickedActionListenerParameter)
    {
        final Frame frame = new Frame();

            final MenuBar menuBar = new MenuBar();

                menuBar.add(new Label("Key:"));

                this.keySpinner = new Spinner(new SpinnerNumberModel(0, 0, 25, 1));
                menuBar.add(this.keySpinner);

                menuBar.add(new Button("Encrypt", onEncryptButtonClickedActionListenerParameter));

                menuBar.add(new Button("Decrypt", onDecryptButtonClickedActionListenerParameter));

                menuBar.add(new Button("Brute force", onBruteForceAttackButtonClickedActionListenerParameter));

            frame.setJMenuBar(menuBar);

            final HorizontalPanel panel = new HorizontalPanel();

                final ScrollPanel inputScrollPanel = new ScrollPanel();

                    this.inputEditableTextArea = new EditableTextArea();
                    inputScrollPanel.getViewport().add(this.inputEditableTextArea);

                panel.add(inputScrollPanel);

                final ScrollPanel outputScrollPanel = new ScrollPanel();

                    this.outputUneditableTextArea = new UneditableTextArea();
                    outputScrollPanel.getViewport().add(this.outputUneditableTextArea);

                panel.add(outputScrollPanel); 

            frame.add(panel);

        frame.setVisible(true); 

        this.inputEditableTextArea.requestFocus();
    }

    public final int getKey()
    {
        return (int)this.keySpinner.getValue();
    }

    public final String getInput()
    {
        return this.inputEditableTextArea.getText();
    }

    public final void setOutput(final String stringParameter)
    {
        this.outputUneditableTextArea.setText(stringParameter);
    }
}
