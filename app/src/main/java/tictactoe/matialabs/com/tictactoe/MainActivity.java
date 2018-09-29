package tictactoe.matialabs.com.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Variables:

    private static int activePlayer = 1; //x=1, 0=0
    private int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2}; // 2 = unplayed
    private static int turnsRemaining = 9;

    public void appear(View view) {
        ImageView counter = (ImageView) view;
        if (counter.getDrawable() == null) //only when there is no image loaded
        {
            if (turnsRemaining != 0)
            {
                counter.setTranslationY(-1000);
                if (activePlayer == 1) {
                    Log.i("Info", "I am here");
                    counter.setImageResource(R.drawable.signx);
                } else {
                    counter.setImageResource(R.drawable.signo);
                }
                counter.animate().translationYBy(1000).setDuration(250);

                updateGameState(counter);
                ProcessGame.update2DGameState(gameState);
                //check for win:
                boolean won = ProcessGame.win(activePlayer);
                turnsRemaining--;
                if (turnsRemaining == 0 && !won)
                {
                    activePlayer = -1; // -1 means tie
                    handleEndGame();
                }
                if (won)
                {
                    handleEndGame();
                }
                activePlayer = (activePlayer == 0) ? 1 : 0; // change active player.
            }
        }
    }

    private void updateGameState(ImageView player) {
        int turn = Integer.parseInt(player.getTag().toString());
        gameState[turn] = activePlayer;

    }

    public static int getActivePlayer() {
        return activePlayer;
    }

    /**
     * The function handles the end game
     */
    private void handleEndGame() {
        // fade the background:
        GridLayout layout = findViewById(R.id.ParentLayout);
        layout.animate().alphaBy(0.5f).setDuration(200);
        //show dialog:
        EndGameDialog endGameDialog = new EndGameDialog();
        endGameDialog.show(getSupportFragmentManager(), "Eng Game poppup.");
    }


}

