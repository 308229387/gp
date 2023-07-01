package com.songyongmeng.gp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;
import com.songyongmeng.gp.dialog.RememberDialog;

import java.util.ArrayList;

public class MainListAdapter extends BaseExpandableListAdapter {
    //Model：定义的数据
    private String[] groups;
    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private String[][] childs;
    private Context context;
    private ArrayList<MainBean> data;


    public MainListAdapter(MainActivity context, ArrayList<MainBean> allData) {
        data = allData;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return data.get(i).getData().size();
    }

    @Override
    public Object getGroup(int i) {
        return data.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return data.get(i).getData().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    public boolean hasStableIds() {
        return true;
    }


    @Override
/**
 *
 * 获取显示指定组的视图对象
 *
 * @param groupPosition 组位置
 * @param isExpanded 该组是展开状态还是伸缩状态，true=展开
 * @param convertView 重用已有的视图对象
 * @param parent 返回的视图对象始终依附于的视图组
 */
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_parent_item, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.parent_textview_id = convertView.findViewById(R.id.parent_textview_id);
            groupViewHolder.parent_image = convertView.findViewById(R.id.parent_image);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.parent_textview_id.setText(data.get(groupPosition).getName());
        //如果是展开状态，
        if (isExpanded) {
//            groupViewHolder.parent_image.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.person_down_arrow));
            groupViewHolder.parent_image.setImageDrawable(context.getDrawable(R.mipmap.person_up_arrow));
        } else {
            groupViewHolder.parent_image.setImageDrawable(context.getDrawable(R.mipmap.person_down_arrow));
//            groupViewHolder.parent_image.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.person_up_arrow));
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_chidren_item, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.parent_view = (LinearLayout) convertView;
            childViewHolder.chidren_item = (TextView) convertView.findViewById(R.id.chidren_item);
            childViewHolder.learn_icon = (ImageView) convertView.findViewById(R.id.learn_icon);
            convertView.setTag(childViewHolder);

        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        String title = data.get(groupPosition).getData().get(childPosition).getRichText().get(0).replace("title:","");
        childViewHolder.chidren_item.setText(title);
        if (Hawk.contains(title)) {
            QABean tmp = Hawk.get(title);
            switch (tmp.getCount()) {
                case 0:
                    childViewHolder.parent_view.setBackgroundColor(Color.parseColor("#ffffff"));
                    break;
                case 1:
                    childViewHolder.parent_view.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case 2:
                    childViewHolder.parent_view.setBackgroundColor(Color.parseColor("#FFD700"));

                    break;
                case 3:
                    childViewHolder.parent_view.setBackgroundColor(Color.parseColor("#006400"));

                    break;
                default:
                    childViewHolder.parent_view.setBackgroundColor(Color.parseColor("#00FF00"));
                    break;
            }
        } else {
            childViewHolder.parent_view.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        childViewHolder.learn_icon.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {


                RememberDialog dialog = new RememberDialog(context, "清除此条状态");
                dialog.setListener(new RememberDialog.RememberDialogCallBack() {
                    @Override
                    public void result() {
                        if (Hawk.contains(data.get(groupPosition).getData().get(childPosition).getRichText().get(0).replace("title:",""))) {
                            QABean tmp = Hawk.get(data.get(groupPosition).getData().get(childPosition).getRichText().get(0).replace("title:",""));
                            tmp.setCount(0);
                            Hawk.put(data.get(groupPosition).getData().get(childPosition).getRichText().get(0).replace("title:",""), tmp);
                            notifyDataSetChanged();
                        }
                        dialog.dismiss();
                    }

                    @Override
                    public void cancel() {
                        dialog.dismiss();
                    }
                }).show();


                return false;
            }
        });
        childViewHolder.learn_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RememberDialog dialog = new RememberDialog(context);
                dialog.setListener(new RememberDialog.RememberDialogCallBack() {
                    @Override
                    public void result() {
                        QABean tmp = Hawk.get(data.get(groupPosition).getData().get(childPosition).getRichText().get(0).replace("title:",""), new QABean());
                        tmp.setCount(tmp.getCount() + 1);
                        Hawk.put(data.get(groupPosition).getData().get(childPosition).getRichText().get(0).replace("title:",""), tmp);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }

                    @Override
                    public void cancel() {
                        dialog.dismiss();
                    }
                }).show();

            }
        });
        return convertView;
    }

    //指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    static class GroupViewHolder {
        TextView parent_textview_id;
        ImageView parent_image;
    }

    static class ChildViewHolder {
        TextView chidren_item;
        ImageView learn_icon;
        LinearLayout parent_view;
    }
}
