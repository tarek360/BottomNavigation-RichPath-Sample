package richpath.com.bottomnavigation;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        initBottomNavigation();
    }

    public void initBottomNavigation() {

        final String homePathData = getString(R.string.ic_home_path);
        final String musicPathData = getString(R.string.ic_music_path);
        final String heartPathData = getString(R.string.ic_heart_path);

        RichPathView bottomNavigation = (RichPathView) findViewById(R.id.bottomNavigation);

        final RichPath selectorRichPath = bottomNavigation.findRichPathByName("selector");
        final RichPath clickableHomeRichPath = bottomNavigation.findRichPathByName("clickable_home");
        final RichPath clickableMusicRichPath = bottomNavigation.findRichPathByName("clickable_music");
        final RichPath clickableHeartRichPath = bottomNavigation.findRichPathByName("clickable_heart");

        clickableHomeRichPath.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick() {
                morphRichPath(selectorRichPath, homePathData);
            }
        });

        clickableMusicRichPath.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick() {
                morphRichPath(selectorRichPath, musicPathData);
            }
        });

        clickableHeartRichPath.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick() {
                morphRichPath(selectorRichPath, heartPathData);
            }
        });

    }

    public void morphRichPath(RichPath richPath, String pathData) {
        RichPathAnimator
                .animate(richPath)
                .pathData(pathData)
                .duration(1000)
                .start();
    }

}
