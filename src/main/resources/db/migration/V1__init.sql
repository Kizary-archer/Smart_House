--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1 (Debian 13.1-1.pgdg100+1)
-- Dumped by pg_dump version 13.1

-- Started on 2021-01-07 18:46:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;


CREATE TABLE public.controller_model (
                                         id_model serial NOT NULL,
                                         model_name character varying(50) NOT NULL,
                                         description character varying(200),
                                         webpage character varying(200),
                                         manufacturer character varying(50)
);


CREATE TABLE public.controllers (
                                    id_controller serial NOT NULL,
                                    "user" integer NOT NULL,
                                    model integer,
                                    start_date timestamp(0) with time zone NOT NULL,
                                    "group" integer NOT NULL,
                                    work_status integer NOT NULL,
                                    name_controller character varying(50) NOT NULL
);

CREATE TABLE public.group_function (
                                       id_group serial NOT NULL,
                                       name_group character varying(50) NOT NULL,
                                       decription character varying(200),
                                       "user" integer NOT NULL
);

CREATE TABLE public.devices (
                                id_device serial NOT NULL,
                                controller integer NOT NULL,
                                type_device integer NOT NULL,
                                start_date timestamp(0) with time zone NOT NULL,
                                work_status integer NOT NULL,
                                name_device character varying(50) NOT NULL,
                                description character varying(200) NOT NULL
);

CREATE TABLE public.function_devices (
                                         id_function serial NOT NULL,
                                         device integer NOT NULL,
                                         type_function integer NOT NULL,
                                         name_function character varying(50) NOT NULL,
                                         description character varying(200),
                                         data integer,
                                         min_data integer,
                                         max_data integer
);

CREATE TABLE public.functions_groups (
                                         function_devices integer NOT NULL,
                                         group_function integer NOT NULL
);

CREATE TABLE public.group_controller (
                                         id_group serial NOT NULL,
                                         name_group character varying(50) NOT NULL,
                                         decription character varying(200)
);

CREATE TABLE public.journal_error (
                                      id_error serial NOT NULL,
                                      type_error integer NOT NULL,
                                      user_request integer,
                                      function_devices integer NOT NULL,
                                      date_error timestamp(0) with time zone NOT NULL,
                                      description character varying(200)
);

CREATE TABLE public.journal_event (
                                      id_event serial NOT NULL,
                                      type_event integer NOT NULL,
                                      function_devices integer NOT NULL,
                                      data integer,
                                      date_event timestamp(0) with time zone NOT NULL,
                                      user_request integer
);

CREATE TABLE public.journal_user_request (
                                             id_request serial NOT NULL,
                                             date_request timestamp(0) with time zone NOT NULL,
                                             "user" integer NOT NULL,
                                             status_request boolean DEFAULT false NOT NULL
);

CREATE TABLE public.permisions (
                                   id_permission serial NOT NULL,
                                   name_permission character varying NOT NULL
);

CREATE TABLE public.permission_user_role (
                                             user_role integer NOT NULL,
                                             permission integer NOT NULL
);

CREATE TABLE public.type_devices (
                                     id_type serial NOT NULL,
                                     name_type character varying(50) NOT NULL,
                                     description character varying(200)
);

CREATE TABLE public.type_error (
                                   id_error serial NOT NULL,
                                   name_error character varying(50) NOT NULL,
                                   description character varying(200)
);

CREATE TABLE public.type_event (
                                   id_event serial NOT NULL,
                                   name_event character varying(50) NOT NULL,
                                   description character varying(200)
);

CREATE TABLE public.type_function (
                                      id_type serial NOT NULL,
                                      name_type character varying(50) NOT NULL,
                                      description character varying(200),
                                      range boolean NOT NULL
);

CREATE TABLE public.user_role (
                                  id_role serial NOT NULL,
                                  name_role character varying(50) NOT NULL,
                                  description character varying(200)
);

CREATE TABLE public.user_status (
                                    id_user_status serial NOT NULL,
                                    status_name character varying(50) NOT NULL,
                                    description character varying(200)
);

CREATE TABLE public.users (
                              id_user serial NOT NULL,
                              login character varying(50) NOT NULL,
                              password character varying(200) NOT NULL,
                              role integer NOT NULL,
                              registration_date timestamp(0) with time zone NOT NULL,
                              status integer NOT NULL
);

CREATE TABLE public.work_status (
                                    id_status serial NOT NULL,
                                    name_status character varying(50) NOT NULL,
                                    description character varying(200)
);

ALTER TABLE ONLY public.controller_model
    ADD CONSTRAINT controller_model_pk PRIMARY KEY (id_model);


ALTER TABLE ONLY public.controller_model
    ADD CONSTRAINT controller_model_un UNIQUE (model_name);


ALTER TABLE ONLY public.controllers
    ADD CONSTRAINT controllers_pk PRIMARY KEY (id_controller);


ALTER TABLE ONLY public.controllers
    ADD CONSTRAINT controllers_un UNIQUE (name_controller);

ALTER TABLE ONLY public.group_function
    ADD CONSTRAINT device_group_pk PRIMARY KEY (id_group);

ALTER TABLE ONLY public.group_function
    ADD CONSTRAINT device_group_un UNIQUE (name_group);

ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_pk PRIMARY KEY (id_device);

ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_un UNIQUE (name_device);

ALTER TABLE ONLY public.function_devices
    ADD CONSTRAINT function_devices_pk PRIMARY KEY (id_function);

ALTER TABLE ONLY public.function_devices
    ADD CONSTRAINT function_devices_un UNIQUE (name_function);

ALTER TABLE ONLY public.functions_groups
    ADD CONSTRAINT functions_groups_un UNIQUE (function_devices, group_function);


--
-- TOC entry 2941 (class 2606 OID 16514)
-- Name: group_controller group_controller_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.group_controller
    ADD CONSTRAINT group_controller_pk PRIMARY KEY (id_group);


--
-- TOC entry 2943 (class 2606 OID 16516)
-- Name: group_controller group_controller_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.group_controller
    ADD CONSTRAINT group_controller_un UNIQUE (name_group);


--
-- TOC entry 2945 (class 2606 OID 16518)
-- Name: journal_error journal_error_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_error
    ADD CONSTRAINT journal_error_pk PRIMARY KEY (id_error);


--
-- TOC entry 2947 (class 2606 OID 16520)
-- Name: journal_event journal_event_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_event
    ADD CONSTRAINT journal_event_pk PRIMARY KEY (id_event);


--
-- TOC entry 2949 (class 2606 OID 16522)
-- Name: journal_user_request journal_user_request_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_user_request
    ADD CONSTRAINT journal_user_request_pk PRIMARY KEY (id_request);


--
-- TOC entry 2951 (class 2606 OID 16524)
-- Name: permisions permisions_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.permisions
    ADD CONSTRAINT permisions_pk PRIMARY KEY (id_permission);


--
-- TOC entry 2953 (class 2606 OID 16526)
-- Name: permisions permisions_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.permisions
    ADD CONSTRAINT permisions_un UNIQUE (name_permission);


--
-- TOC entry 2955 (class 2606 OID 16528)
-- Name: permission_user_role permission_use_role_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.permission_user_role
    ADD CONSTRAINT permission_use_role_un UNIQUE (user_role, permission);


--
-- TOC entry 2957 (class 2606 OID 16530)
-- Name: type_devices type_devices_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_devices
    ADD CONSTRAINT type_devices_pk PRIMARY KEY (id_type);


--
-- TOC entry 2959 (class 2606 OID 16532)
-- Name: type_devices type_devices_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_devices
    ADD CONSTRAINT type_devices_un UNIQUE (name_type);


--
-- TOC entry 2961 (class 2606 OID 16534)
-- Name: type_error type_error_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_error
    ADD CONSTRAINT type_error_pk PRIMARY KEY (id_error);


--
-- TOC entry 2963 (class 2606 OID 16536)
-- Name: type_error type_error_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_error
    ADD CONSTRAINT type_error_un UNIQUE (name_error);


--
-- TOC entry 2965 (class 2606 OID 16538)
-- Name: type_event type_event_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_event
    ADD CONSTRAINT type_event_pk PRIMARY KEY (id_event);


--
-- TOC entry 2967 (class 2606 OID 16540)
-- Name: type_event type_event_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_event
    ADD CONSTRAINT type_event_un UNIQUE (name_event);


--
-- TOC entry 2969 (class 2606 OID 16542)
-- Name: type_function type_function_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_function
    ADD CONSTRAINT type_function_pk PRIMARY KEY (id_type);


--
-- TOC entry 2971 (class 2606 OID 16544)
-- Name: type_function type_function_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.type_function
    ADD CONSTRAINT type_function_un UNIQUE (name_type);


--
-- TOC entry 2973 (class 2606 OID 16546)
-- Name: user_role user_role_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pk PRIMARY KEY (id_role);


--
-- TOC entry 2975 (class 2606 OID 16548)
-- Name: user_role user_role_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_un UNIQUE (name_role);


--
-- TOC entry 2977 (class 2606 OID 16550)
-- Name: user_status user_status_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_status
    ADD CONSTRAINT user_status_pk PRIMARY KEY (id_user_status);


--
-- TOC entry 2979 (class 2606 OID 16552)
-- Name: user_status user_status_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_status
    ADD CONSTRAINT user_status_un UNIQUE (status_name);


--
-- TOC entry 2981 (class 2606 OID 16554)
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id_user);


--
-- TOC entry 2983 (class 2606 OID 16556)
-- Name: users users_un; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_un UNIQUE (login);


--
-- TOC entry 2985 (class 2606 OID 16558)
-- Name: work_status work_status_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.work_status
    ADD CONSTRAINT work_status_pk PRIMARY KEY (id_status);


--
-- TOC entry 2986 (class 2606 OID 16559)
-- Name: controllers controllers_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.controllers
    ADD CONSTRAINT controllers_fk FOREIGN KEY (work_status) REFERENCES public.work_status(id_status);


--
-- TOC entry 2987 (class 2606 OID 16564)
-- Name: controllers controllers_fk2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.controllers
    ADD CONSTRAINT controllers_fk2 FOREIGN KEY ("user") REFERENCES public.users(id_user);


--
-- TOC entry 2988 (class 2606 OID 16569)
-- Name: controllers controllers_fk3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.controllers
    ADD CONSTRAINT controllers_fk3 FOREIGN KEY ("group") REFERENCES public.group_controller(id_group);


--
-- TOC entry 2989 (class 2606 OID 16574)
-- Name: controllers controllers_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.controllers
    ADD CONSTRAINT controllers_fk_1 FOREIGN KEY (model) REFERENCES public.controller_model(id_model);


--
-- TOC entry 2991 (class 2606 OID 16579)
-- Name: devices devices_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_fk FOREIGN KEY (type_device) REFERENCES public.type_devices(id_type);


--
-- TOC entry 2992 (class 2606 OID 16584)
-- Name: devices devices_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_fk_1 FOREIGN KEY (work_status) REFERENCES public.work_status(id_status);


--
-- TOC entry 2993 (class 2606 OID 16589)
-- Name: devices devices_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_fk_2 FOREIGN KEY (controller) REFERENCES public.controllers(id_controller);


--
-- TOC entry 2994 (class 2606 OID 16594)
-- Name: function_devices function_devices_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.function_devices
    ADD CONSTRAINT function_devices_fk FOREIGN KEY (device) REFERENCES public.devices(id_device);


--
-- TOC entry 2995 (class 2606 OID 16599)
-- Name: function_devices function_devices_fk2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.function_devices
    ADD CONSTRAINT function_devices_fk2 FOREIGN KEY (type_function) REFERENCES public.type_function(id_type);


--
-- TOC entry 2996 (class 2606 OID 16604)
-- Name: functions_groups functions_groups_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.functions_groups
    ADD CONSTRAINT functions_groups_fk FOREIGN KEY (function_devices) REFERENCES public.function_devices(id_function);


--
-- TOC entry 2997 (class 2606 OID 16609)
-- Name: functions_groups functions_groups_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.functions_groups
    ADD CONSTRAINT functions_groups_fk_1 FOREIGN KEY (group_function) REFERENCES public.group_function(id_group);


--
-- TOC entry 2990 (class 2606 OID 16614)
-- Name: group_function group_function_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.group_function
    ADD CONSTRAINT group_function_fk FOREIGN KEY ("user") REFERENCES public.users(id_user);


--
-- TOC entry 2998 (class 2606 OID 16619)
-- Name: journal_error journal_error_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_error
    ADD CONSTRAINT journal_error_fk FOREIGN KEY (function_devices) REFERENCES public.function_devices(id_function);


--
-- TOC entry 2999 (class 2606 OID 16624)
-- Name: journal_error journal_error_fk2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_error
    ADD CONSTRAINT journal_error_fk2 FOREIGN KEY (type_error) REFERENCES public.type_error(id_error);


--
-- TOC entry 3000 (class 2606 OID 16629)
-- Name: journal_error journal_error_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_error
    ADD CONSTRAINT journal_error_fk_1 FOREIGN KEY (user_request) REFERENCES public.journal_user_request(id_request);


--
-- TOC entry 3001 (class 2606 OID 16634)
-- Name: journal_event journal_event_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_event
    ADD CONSTRAINT journal_event_fk FOREIGN KEY (user_request) REFERENCES public.journal_user_request(id_request);


--
-- TOC entry 3002 (class 2606 OID 16639)
-- Name: journal_event journal_event_fk2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_event
    ADD CONSTRAINT journal_event_fk2 FOREIGN KEY (type_event) REFERENCES public.type_event(id_event);


--
-- TOC entry 3003 (class 2606 OID 16644)
-- Name: journal_event journal_event_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_event
    ADD CONSTRAINT journal_event_fk_1 FOREIGN KEY (function_devices) REFERENCES public.function_devices(id_function);


--
-- TOC entry 3004 (class 2606 OID 16649)
-- Name: journal_user_request journal_user_request_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.journal_user_request
    ADD CONSTRAINT journal_user_request_fk FOREIGN KEY ("user") REFERENCES public.users(id_user);


--
-- TOC entry 3005 (class 2606 OID 16654)
-- Name: permission_user_role permission_use_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.permission_user_role
    ADD CONSTRAINT permission_use_role_fk FOREIGN KEY (user_role) REFERENCES public.user_role(id_role);


--
-- TOC entry 3006 (class 2606 OID 16659)
-- Name: permission_user_role permission_use_role_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.permission_user_role
    ADD CONSTRAINT permission_use_role_fk_1 FOREIGN KEY (permission) REFERENCES public.permisions(id_permission);


--
-- TOC entry 3007 (class 2606 OID 16664)
-- Name: users users_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_fk FOREIGN KEY (role) REFERENCES public.user_role(id_role);


--
-- TOC entry 3008 (class 2606 OID 16669)
-- Name: users users_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_fk_1 FOREIGN KEY (status) REFERENCES public.user_status(id_user_status);


-- Completed on 2021-01-07 18:46:33

--
-- PostgreSQL database dump complete
--

