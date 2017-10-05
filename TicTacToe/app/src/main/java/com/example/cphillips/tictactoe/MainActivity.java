package com.example.cphillips.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Button00;
    Button Button01;
    Button Button02;
    Button Button10;
    Button Button11;
    Button Button12;
    Button Button20;
    Button Button21;
    Button Button22;
    private TextView WhosTurn;
    private String[][] Board;
    private Button[][] Buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitComponents();
    }

    private void InitComponents(){
        Board = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Board[i][j] = null;
            }
        }
        Buttons = new Button[3][3];
        InitButtons();
        WhosTurn = (TextView)findViewById(R.id.textView);
        WhosTurn.setText("X");
    }

    private boolean Win(){
        Button00.setClickable(false);
        Button01.setClickable(false);
        Button02.setClickable(false);
        Button10.setClickable(false);
        Button11.setClickable(false);
        Button12.setClickable(false);
        Button20.setClickable(false);
        Button21.setClickable(false);
        Button22.setClickable(false);
        return true;
    }

    private boolean CheckColNotNull(int col){
        boolean colNotNull = true;
        if(Board[0][col] == null || Board[1][col] == null || Board[2][col] == null){
            colNotNull = false;
        }
        return colNotNull;
    }

    private boolean CheckRowNotNull(int row){
        boolean rowNotNull = true;
        if(Board[row][0] == null || Board[row][1] == null || Board[row][2] == null){
            rowNotNull = false;
        }
        return rowNotNull;
    }

    private boolean CheckD45NotNull(){
        boolean notNull = true;
        if(Board[2][0] == null || Board[1][1] == null || Board[0][2] == null){
            notNull = false;
        }
        return notNull;
    }

    private boolean CheckD135NotNull(){
        boolean notNull = true;
        if(Board[0][0] == null || Board[1][1] == null || Board[2][2] == null){
            notNull = false;
        }
        return notNull;
    }

    private boolean CheckRow(int row, String player){
        boolean win = false;
        if(CheckRowNotNull(row)){
            if(Board[row][0].equals(player) && Board[row][1].equals(player) && Board[row][2].equals(player)){
                win = true;
            }
        }
        return win;
    }

    private boolean CheckCol(int col, String player){
        boolean win = false;
        if(CheckColNotNull(col)){
            if(Board[0][col].equals(player) && Board[1][col].equals(player) && Board[2][col].equals(player)){
                win = true;
            }
        }
        return win;
    }

    private boolean CheckD45(String player){
        boolean win = false;
        if(CheckD45NotNull()){
            if(Board[2][0].equals(player) && Board[1][1].equals(player) && Board[0][2].equals(player)){
                win = true;
            }
        }
        return win;
    }

    private boolean CheckD135(String player){
        boolean win = false;
        if(CheckD135NotNull()){
            if(Board[0][0].equals(player) && Board[1][1].equals(player) && Board[2][2].equals(player)){
                win = true;
            }
        }
        return win;
    }

    private boolean CheckForWin(String player){
        boolean win = false;
        for(int i = 0; i < 3; i++){
           if(CheckRow(i, player) || CheckCol(i, player)){
               win = true;
           }
        }
        if(CheckD45(player) || CheckD135(player)){
            win = true;
        }
        return win;
    }

    private void ChangePlayer(){
        if (WhosTurn.getText().toString().equals("X")) {
            WhosTurn.setText("O");
        } else{
            WhosTurn.setText("X");
        }
    }

    private void MarkCell(View v, int[] index){
        Button cellButton = (Button)findViewById(v.getId());
        cellButton.setText(WhosTurn.getText().toString());
        Board[index[0]][index[1]] = WhosTurn.getText().toString();
        cellButton.setEnabled(false);
        if(CheckForWin(WhosTurn.getText().toString())){
            Win();
        } else {
            ChangePlayer();
        }
    }

    private void InitButtons(){
        Buttons[0][0] = Button00 = (Button)findViewById(R.id.button00);
        Button00.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{0,0});
            }
        });

        Buttons[0][1] = Button01 = (Button)findViewById(R.id.button01);
        Button01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{0,1});
            }
        });

        Buttons[0][2] = Button02 = (Button)findViewById(R.id.button02);
        Button02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{0,2});
            }
        });

        Buttons[1][0] = Button10 = (Button)findViewById(R.id.button10);
        Button10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{1,0});
            }
        });

        Buttons[1][1] = Button11 = (Button)findViewById(R.id.button11);
        Button11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{1,1});
            }
        });

        Buttons[1][2] = Button12 = (Button)findViewById(R.id.button12);
        Button12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{1,2});
            }
        });

        Buttons[2][0] = Button20 = (Button)findViewById(R.id.button20);
        Button20.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{2,0});
            }
        });

        Buttons[2][1] = Button21 = (Button)findViewById(R.id.button21);
        Button21.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{2,1});
            }
        });

        Buttons[2][2] = Button22 = (Button)findViewById(R.id.button22);
        Button22.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MarkCell(view, new int[]{2,2});
            }
        });
    }

}
