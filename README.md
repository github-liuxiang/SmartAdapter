# Smartadapter
#引入
        
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
		}
        dependencies {
	        implementation 'com.github.github-liuxiang:Smartadapter:v3.2'
		}    
		
		
#使用
       
       //可适配listview,gridview单一布局
         SmartAdapter<String> smartAdapter= new SmartAdapter<String>(this,datas,1) {
           @Override
           public void convert(SmartViewHolder paramViewHolder, String paramT, int position) {
              
           }
         };
        //适配listview,gridview多种布局
        MutSmartAdapter<String> mutSmartAdapter = new MutSmartAdapter<String>(this,datas) {
            @Override
            public int getItemLayout(int positon, String paramT) {
                //返回itemid
                return 0;
            }

            @Override
            public void convert(SmartViewHolder paramViewHolder, String paramT, int position, int itemId) {

            }
        };
         //recyclerview单一布局
        SmartRecyclerAdapter<String> stringSmartRecyclerAdapter= new SmartRecyclerAdapter<String>(this,1,datas) {
            @Override
            public void convert(SmartRecyclerHolder holder, String item, int position) {

            }
        };
        //recyclerview多布局
        MutSmartRecyclerAdapter mutSmartRecyclerAdapter= new MutSmartRecyclerAdapter(this,datas) {
            @Override
            public void convert(SmartRecyclerHolder holder, Object item, int position, int itemId) {

            }

            @Override
            public int getItemLayout(int position, Object paramT) {
                return 0;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }
        };
