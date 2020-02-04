package com.example.androidsceneform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Error" ;
    ArFragment arFragment;
    private ModelRenderable bearRenderable,
                            catRenderable,
                            dogRenderable,
                            cowRenderable,
                            elephantRenderable,
                            ferretRenderable,
                            hippopotamusRenderable,
                            horseRenderable,
                            koala_bearRenderable,
                            lionRenderable,
                            reindeerRenderable,
                            wolverineRenderable;

    ImageView bear,cow,dog,elephant,ferret,hippo,horse,koala,lion,reindeer,wolverine;

    View arrayView[];
    ViewRenderable name_animal;

    int selected = 1; // Default Bear is selected


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        //View
        bear = findViewById(R.id.bear);
        cow = findViewById(R.id.cow);
        dog = findViewById(R.id.dog);
        elephant = findViewById(R.id.elephant);
        ferret = findViewById(R.id.ferret);
        hippo = findViewById(R.id.hippopotamus);
        horse = findViewById(R.id.horse);
        koala = findViewById(R.id.koala_bear);
        lion = findViewById(R.id.lion);
        reindeer = findViewById(R.id.reindeer);
        wolverine = findViewById(R.id.wolverine);

        setArrayView();
        setClickListener();

        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                //When user taps on a plane surface, a model will be added

                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode, selected);
            }
        });
    }

    private void setupModel() {
        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build()
                .thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cat Model", Toast.LENGTH_SHORT).show();
                            return null;
                        });


        ModelRenderable.builder()
                .setSource(this,R.raw.cat)
                .build()
                .thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cat Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.cow)
                .build()
                .thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cow Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.dog)
                .build()
                .thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cat Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.elephant)
                .build()
                .thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cat Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.ferret)
                .build()
                .thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cat Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.hippopotamus)
                .build()
                .thenAccept(renderable -> hippopotamusRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load cat Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.horse)
                .build()
                .thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load horse Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.koala_bear)
                .build()
                .thenAccept(renderable -> koala_bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load koala Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.lion)
                .build()
                .thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load lion Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.reindeer)
                .build()
                .thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load reindeer Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.wolverine)
                .build()
                .thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load wolverine Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected ==1 ){
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();
        }

//        if (selected ==1 ){
//            TransformableNode cat = new TransformableNode(arFragment.getTransformationSystem());
//            cat.setParent(anchorNode);
//            cat.setRenderable(catRenderable);
//            cat.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode cow = new TransformableNode(arFragment.getTransformationSystem());
//            cow.setParent(anchorNode);
//            cow.setRenderable(cowRenderable);
//            cow.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode dog = new TransformableNode(arFragment.getTransformationSystem());
//            dog.setParent(anchorNode);
//            dog.setRenderable(dogRenderable);
//            dog.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode elephant = new TransformableNode(arFragment.getTransformationSystem());
//            elephant.setParent(anchorNode);
//            elephant.setRenderable(elephantRenderable);
//            elephant.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode ferret = new TransformableNode(arFragment.getTransformationSystem());
//            ferret.setParent(anchorNode);
//            ferret.setRenderable(ferretRenderable);
//            ferret.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode hippopotamus = new TransformableNode(arFragment.getTransformationSystem());
//            hippopotamus.setParent(anchorNode);
//            hippopotamus.setRenderable(hippopotamusRenderable);
//            hippopotamus.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode horse = new TransformableNode(arFragment.getTransformationSystem());
//            horse.setParent(anchorNode);
//            horse.setRenderable(horseRenderable);
//            horse.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode koala = new TransformableNode(arFragment.getTransformationSystem());
//            koala.setParent(anchorNode);
//            koala.setRenderable(koala_bearRenderable);
//            koala.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode lion = new TransformableNode(arFragment.getTransformationSystem());
//            lion.setParent(anchorNode);
//            lion.setRenderable(lionRenderable);
//            lion.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode reindeer = new TransformableNode(arFragment.getTransformationSystem());
//            reindeer.setParent(anchorNode);
//            reindeer.setRenderable(reindeerRenderable);
//            reindeer.select();
//        }
//
//        if (selected ==1 ){
//            TransformableNode wolverine = new TransformableNode(arFragment.getTransformationSystem());
//            wolverine.setParent(anchorNode);
//            wolverine.setRenderable(wolverineRenderable);
//            wolverine.select();
//        }
    }

    private void setClickListener() {
        for (View view : arrayView) {
            view.setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView = new View []{
                bear,cow,dog,elephant,ferret,hippo,horse,koala,lion,reindeer,wolverine
        };
    }

    @Override
    public void onClick(View view) {

    }
}
