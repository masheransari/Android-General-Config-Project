package com.dotinfiny.banglesystem.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.dotinfiny.banglesystem.database.DatabaseConfig;

public class DatabaseRepository {
    private Context context;

    public DatabaseRepository(Context context) {
        this.context = context;
    }

    public void removeAllTables() {
        new deleteAllTables(DatabaseConfig.Companion.getInstance(context)).execute();
    }

    private class deleteAllTables extends AsyncTask<Void, Void, Void> {
        private DatabaseConfig config;

        public deleteAllTables(DatabaseConfig config) {
            this.config = config;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            config.clearAllTables();
            return null;
        }
    }


}
