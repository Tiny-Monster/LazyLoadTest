package com.tinymonster.lazyloadtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by TinyMonster on 07/01/2019.
 */

public class MyFragment extends Fragment{
    private String data;
    private boolean isViewInit; //view是否已经加载完成
    private boolean isVisible; //是否可见
    private boolean isFirstLoad = true;//是否第一次加载数据
    public MyFragment(){
    }

    public MyFragment(String data){
        this.data=data;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(data,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(data,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(data,"onCreateView");
        View view=inflater.inflate(R.layout.my_fragment,null);
        TextView textView=(TextView)view.findViewById(R.id.text);
        textView.setText(data);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInit=true;
        lazyLoad();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(data,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(data,"onResume");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(data,"setUserVisibleHint:"+isVisibleToUser);
        if(isVisibleToUser){
            isVisible=true;
            lazyLoad();
        }else {
            isVisible=false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(data,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(data,"onDestroy");
    }

    /**
     * 懒加载逻辑
     */
    private void lazyLoad() {
        if (!isViewInit || !isVisible || !isFirstLoad) {   //view加载完成  可见 且是第一次加载时才加载数据
            return;
        }
        loadData();
        isFirstLoad = false;
    }

    /**
     * 模拟加载数据
     */
    protected void loadData(){
        Log.e(data,"加载数据！");
    }
}
