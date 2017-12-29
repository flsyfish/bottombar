# bottombar
仿闲鱼底部导航支持本地和网络图片
##

### 加载本地图片代码



    StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_checked},
                getApplicationContext().getResources().getDrawable(checked));
        drawable.addState(new int[]{ - android.R.attr.state_checked},
                getApplicationContext().getResources().getDrawable(unchecked));

        // 生成的Selector 添加到RadioButton 上面
        
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
       
        btn.setCompoundDrawables(null,drawable,null,null);

### 加载网络图片代码

    Glide.with(this).load(comui_tab_home_selected).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                StateListDrawable drawable = new StateListDrawable();
                drawable.addState(new int[]{android.R.attr.state_checked},
                        resource);
                drawable.addState(new int[]{ - android.R.attr.state_checked},
                        resource);
                    drawable.setBounds(0, 0,90 , 90);
                
                btn.setCompoundDrawables(null,drawable,null,null);
            }
        });

### 加载网络图片

![](https://i.imgur.com/7dXTwWm.png)

### 加载本地图片

![](https://i.imgur.com/DVyZTs1.png)

