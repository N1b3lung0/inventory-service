SELECT 'CREATE DATABASE inventories'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'inventories')\gexec