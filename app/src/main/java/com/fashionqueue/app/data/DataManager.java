package com.fashionqueue.app.data;

public class DataManager {
/*
    public Observable<Boolean> onNewUserCreate(final DatabaseReference database) {

        return Observable.create(new ObservableOnSubscribe<List<WebsitesResponse>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<WebsitesResponse>> e) throws Exception {
                database.orderByKey().limitToLas t(600).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        try {
                            ArrayList<WebsitesResponse> websitesResponses = new ArrayList<>();

                            for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                                if (dataSnapshot.hasChildren()) {
                                    WebsitesResponse dataModal = noteDataSnapshot.getValue(WebsitesResponse.class);
                                    dataModal.setWebId(noteDataSnapshot.getKey());
                                    websitesResponses.add(dataModal);
                                } else {
                                    DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                                    firstChild.getRef().removeValue();
                                }
                            }
                            e.onNext(websitesResponses);
                        } catch (
                                Exception ex)

                        {
                            e.onError(ex);
                            ex.printStackTrace();
                        } finally

                        {
                            e.onComplete();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });

            }
        });
    }

    public Observable<List<String>> getModules(final DatabaseReference database) {

        return Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<String>> e) throws Exception {
                database.orderByKey().limitToLast(600).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        try {
                            ArrayList<String> modulesList = new ArrayList<>();

                            for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                                if (dataSnapshot.hasChildren()) {
                                    String dataModal = noteDataSnapshot.getKey();
                                    modulesList.add(dataModal);
                                } else {
                                    DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                                    firstChild.getRef().removeValue();
                                }
                            }
                            e.onNext(modulesList);
                        } catch (Exception ex) {
                            e.onError(ex);
                            ex.printStackTrace();
                        } finally {
                            e.onComplete();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });

            }
        });
    }


    public Observable<Boolean> crawlWebsite(final List<WebsitesResponse> websitesResponses) {

        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                Document doc;

                for (int i = 0; i < websitesResponses.size(); i++) {

                    try {
                        doc = Jsoup.connect(websitesResponses.get(i).getWeb_page_link()).get();
                        // get title of the page
                        String title = doc.title();
                        System.out.println("Title: " + title);

                        // get all links
                        Elements links = doc.select("a[href]");
                        for (Element link : links) {
                                if (!link.text().equals("") && !link.attr("href").equals("")) {
                                    if (link.attr("href").contains(websitesResponses.get(i).getFilters())){

                                        FirebaseDataManager.postNewsIntoFireBase(websitesResponses.get(i).getLanguage(),
                                            websitesResponses.get(i).getCategory_id(), link.text(), link.attr("href"), "", "");
                                }
                            }

                        }
                        e.onNext(true);
                        e.onComplete();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }


            }


        });

    }

    ;

    public Observable<List<CategoryResponse>> getCategoriesOfLanguage(final DatabaseReference database) {

        return Observable.create(new ObservableOnSubscribe<List<CategoryResponse>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<CategoryResponse>> e) throws Exception {
                database.orderByKey()
                        .limitToLast(600).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        try {
                            ArrayList<CategoryResponse> categoriesList = new ArrayList<>();

                            for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                                if (dataSnapshot.hasChildren()) {
                                    String key = noteDataSnapshot.getKey();
                                    String value = (String) noteDataSnapshot.getValue();
                                    categoriesList.add(new CategoryResponse(value, key));
                                } else {
                                    DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                                    firstChild.getRef().removeValue();
                                }
                            }
                            e.onNext(categoriesList);
                        } catch (Exception ex) {
                            e.onError(ex);
                            ex.printStackTrace();
                        } finally {
                            e.onComplete();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }
        });
    }
*/


}
