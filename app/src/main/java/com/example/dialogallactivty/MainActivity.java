package com.example.dialogallactivty;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAnswer;
    private Button btnDan;
    private Button btnDuo;
    private Button btnProgress;
    private Button btnPop;
    private Button getBtnProgressNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnswer = findViewById(R.id.btn_answer);
        btnDan = findViewById(R.id.btn_dan);
        btnDuo = findViewById(R.id.btn_duo);
        btnProgress = findViewById(R.id.btn_progress);
        btnPop = findViewById(R.id.btn_pop);
        getBtnProgressNull = findViewById(R.id.btn_progress_null);
        btnAnswer.setOnClickListener(this);
        btnDan.setOnClickListener(this);
        btnDuo.setOnClickListener(this);
        btnProgress.setOnClickListener(this);
        btnPop.setOnClickListener(this);
        getBtnProgressNull.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        //通知对话框
        switch (v.getId()) {
            case R.id.btn_answer:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("对话框标题");
                builder.setMessage("确定浏览吗?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定点击了", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.btn_dan:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("单选对话框");
                final String[] item = new String[]{"条目一", "条目二", "条目三"};
                builder1.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定点击了条目" + item[which], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
//                builder1.setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "确定点击了", Toast.LENGTH_SHORT).show();
//                    }
//                });
                builder1.show();
                break;
            case R.id.btn_duo:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("多选对话框");
                final String[] item1 = new String[]{"条目一", "条目二", "条目三", "条目四"};
                builder2.setMultiChoiceItems(item1, new boolean[]{true, false, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(MainActivity.this, "确定点击了条目" + item1[which] + isChecked, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();//点击关闭
                    }
                });
                builder2.show();
                break;
            case R.id.btn_progress:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("进度条");
                progressDialog.setMessage("正在加载中");
                progressDialog.show();
                break;
            //提醒对话框
            case R.id.btn_pop:
                final ProgressDialog progressDialog1 = new ProgressDialog(this);
                progressDialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog1.setMax(100);
                progressDialog1.show();
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            progressDialog1.setProgress(i);
                            try {
                                Thread.sleep(20);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        progressDialog1.dismiss();
                    }

                }.start();
                break;
            case R.id.btn_progress_null:
                final ProgressBar progressBar = new ProgressBar(this);
                setProgressBarIndeterminateVisibility(true);
                progressBar.setTag(true);
                progressBar.setScrollBarStyle(progressBar.getScrollBarStyle());
                progressBar.setMax(100);
                progressBar.isShown();
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            progressBar.setProgress(i);
                            try {
                                Thread.sleep(20);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }.start();
                break;
            default:

                break;
        }


    }
}
