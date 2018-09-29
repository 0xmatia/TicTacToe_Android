package tictactoe.matialabs.com.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;

public class EndGameDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        int winningPlayer = MainActivity.getActivePlayer();
        Log.i("Info", winningPlayer+"");
        String title = "";
        if (winningPlayer == 1) {
            title = "Player X won!";
        } else if (winningPlayer == 0) {
            title = "Player O won!";
        } else if (winningPlayer == -1) {
            title = "It's a tie!";
        }
        builder.setTitle(title)
                .setMessage("ggwp")
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do stuff
                    }
                })
                .setNegativeButton("Exit game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setNeutralButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
