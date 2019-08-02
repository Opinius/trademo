CREATE TABLE object_types
(
  id          SERIAL,
  name        VARCHAR(128) NOT NULL,
  independent BOOLEAN NOT NULL DEFAULT true,
  CONSTRAINT types_pk PRIMARY KEY (id)
);
COMMENT ON TABLE object_types IS 'Object types available on factory';

CREATE TABLE factory_objects
(
  id         SERIAL,
  type_id    INTEGER NOT NULL,
  subtype    VARCHAR(32),
  name       VARCHAR(128) NOT NULL,
  attributes JSONB,
  CONSTRAINT objects_pk PRIMARY KEY (id),
  CONSTRAINT object_type_fk FOREIGN KEY (type_id) REFERENCES object_types (id)
);
COMMENT ON TABLE factory_objects IS 'Objects available on factory';

CREATE TABLE scenes
(
  id       SERIAL,
  name     VARCHAR(128) NOT NULL,
  length   INTEGER,
  width    INTEGER,
  height   INTEGER,
  weight   INTEGER,
  CONSTRAINT scenes_pk PRIMARY KEY (id)
);
COMMENT ON TABLE scenes IS 'All scenes';

CREATE TABLE scenes_objects
(
  id                SERIAL,
  scene_id          INTEGER NOT NULL,
  factory_object_id INTEGER NOT NULL,
  label             VARCHAR(128),
  x                 INTEGER,
  y                 INTEGER,
  parent_object_id  INTEGER,
  CONSTRAINT scenes_objects_pk PRIMARY KEY (id),
  CONSTRAINT scene_id_fk FOREIGN KEY (scene_id) REFERENCES scenes (id),
  CONSTRAINT object_id_fk FOREIGN KEY (factory_object_id) REFERENCES factory_objects (id),
  CONSTRAINT parent_object_fk FOREIGN KEY (parent_object_id) REFERENCES scenes_objects (id)
);
COMMENT ON TABLE scenes IS 'Objects on scenes';
