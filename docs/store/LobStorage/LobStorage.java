���������й�:
LOBS
LOB_DATA
LOB_MAP


LOBS:
-------------
CREATE CACHED TABLE IF NOT EXISTS INFORMATION_SCHEMA.LOBS
	(ID BIGINT PRIMARY KEY, BYTE_COUNT BIGINT, TABLE INT) HIDDEN


LOB_DATA:
-------------
CREATE CACHED TABLE IF NOT EXISTS INFORMATION_SCHEMA.LOB_DATA
	(BLOCK BIGINT PRIMARY KEY, COMPRESSED INT, DATA BINARY) HIDDEN


LOB_MAP:
-------------
CREATE CACHED TABLE IF NOT EXISTS INFORMATION_SCHEMA.LOB_MAP
	(LOB BIGINT, SEQ INT, POS BIGINT, HASH INT, BLOCK BIGINT, PRIMARY KEY(LOB, SEQ)) HIDDEN

LOBS����ID�ֶκ�LOB_MAP��LOB�ֶζ�Ӧ��ֵһ��(����lobId)


���⻹����������:

��LOBS���ϵ�����: INDEX_LOB_TABLE
-------------
CREATE INDEX IF NOT EXISTS INFORMATION_SCHEMA.INDEX_LOB_TABLE ON INFORMATION_SCHEMA.LOBS(TABLE)

��LOB_MAP���ϵ�����: INDEX_LOB_MAP_DATA_LOB
-------------
CREATE INDEX IF NOT EXISTS INFORMATION_SCHEMA.INDEX_LOB_MAP_DATA_LOB ON INFORMATION_SCHEMA.LOB_MAP(BLOCK, LOB)



�������ݶ�ӦԴ�����: org.h2.store.LobStorage.init()
