package in.tt.tt17.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import in.tt.tt17.R;
import in.tt.tt17.activities.CategoryActivity;
import in.tt.tt17.models.categories.CategoryModel;
import in.tt.tt17.resources.IconCollection;

/**
 * Created by skvrahul on 15/7/17.
 */
public class HomeCategoriesAdapter extends RecyclerView.Adapter<HomeCategoriesAdapter. HomeViewHolder> {
    String TAG = "HomeCategoriesAdapter";
    private List<CategoryModel> categoriesList;
    private Context context;
    Activity activity;

    public HomeCategoriesAdapter(List<CategoryModel> categoriesList, Activity activity) {
        this.categoriesList = categoriesList;
        this.activity = activity;
    }
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_categories, parent, false);
        context = parent.getContext();
        return new  HomeViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder( HomeViewHolder holder, int position) {
        CategoryModel category = categoriesList.get(position);
        holder.onBind(category);
        IconCollection icons = new IconCollection();
        holder.categoryLogo.setImageResource(icons.getIconResource(activity, category.getCategoryName()));
    }
    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class  HomeViewHolder extends RecyclerView.ViewHolder {
        public ImageView categoryLogo;
        public TextView categoryName;
        public RelativeLayout categoryItem;
        public  HomeViewHolder(View view) {
            super(view);
            initializeViews(view);
        }
        public void onBind(final CategoryModel category) {
            categoryName.setText(category.getCategoryName());
            categoryItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CategoryActivity.class);
                    intent.putExtra("catName", category.getCategoryName());
                    intent.putExtra("catID", category.getCategoryID());
                    intent.putExtra("catDesc", category.getCategoryDescription());
                    context.startActivity(intent);
                }
            });
        }
        public void initializeViews(View view){
            categoryLogo = (ImageView) view.findViewById(R.id.home_category_logo_image_view);
            categoryName = (TextView) view.findViewById(R.id.home_category_name_text_view);
            categoryItem = (RelativeLayout)view.findViewById(R.id.home_categories_item);
        }
    }
}