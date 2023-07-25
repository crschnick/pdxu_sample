package com.crschnick.pdxu.sample;

import java.util.*;

public class DNA {
    public static String HEADER =
            "ruler_designer_1560552532=\n" +
                    "{\n" +
                    "	genes={\n";


    public static String[] GENES = new String[]
            {
                    "hair_color",
                    "skin_color",
                    "eye_color",
                    "gene_chin_forward",
                    "gene_chin_height",
                    "gene_chin_width",
                    "gene_eye_angle",
                    "gene_eye_depth",
                    "gene_eye_height",
                    "gene_eye_distance",
                    "gene_eye_shut",
                    "gene_forehead_angle",
                    "gene_forehead_brow_height",
                    "gene_forehead_roundness",
                    "gene_forehead_width",
                    "gene_forehead_height",
                    "gene_head_height",
                    "gene_head_width",
                    "gene_head_profile",
                    "gene_head_top_height",
                    "gene_head_top_width",
                    "gene_jaw_angle",
                    "gene_jaw_forward",
                    "gene_jaw_height",
                    "gene_jaw_width",
                    "gene_mouth_corner_depth",
                    "gene_mouth_corner_height",
                    "gene_mouth_forward",
                    "gene_mouth_height",
                    "gene_mouth_width",
                    "gene_mouth_upper_lip_size",
                    "gene_mouth_lower_lip_size",
                    "gene_mouth_open",
                    "gene_neck_length",
                    "gene_neck_width",
                    "gene_bs_cheek_forward",
                    "gene_bs_cheek_height",
                    "gene_bs_cheek_width",
                    "gene_bs_ear_angle",
                    "gene_bs_ear_inner_shape",
                    "gene_bs_ear_bend",
                    "gene_bs_ear_outward",
                    "gene_bs_ear_size",
                    "gene_bs_eye_corner_depth",
                    "gene_bs_eye_fold_shape",
                    "gene_bs_eye_size",
                    "gene_bs_eye_upper_lid_size",
                    "gene_bs_forehead_brow_curve",
                    "gene_bs_forehead_brow_forward",
                    "gene_bs_forehead_brow_inner_height",
                    "gene_bs_forehead_brow_outer_height",
                    "gene_bs_forehead_brow_width",
                    "gene_bs_jaw_def",
                    "gene_bs_mouth_lower_lip_def",
                    "gene_bs_mouth_lower_lip_full",
                    "gene_bs_mouth_lower_lip_pad",
                    "gene_bs_mouth_lower_lip_width",
                    "gene_bs_mouth_philtrum_def",
                    "gene_bs_mouth_philtrum_shape",
                    "gene_bs_mouth_philtrum_width",
                    "gene_bs_mouth_upper_lip_def",
                    "gene_bs_mouth_upper_lip_full",
                    "gene_bs_mouth_upper_lip_profile",
                    "gene_bs_mouth_upper_lip_width",
                    "gene_bs_nose_forward",
                    "gene_bs_nose_height",
                    "gene_bs_nose_length",
                    "gene_bs_nose_nostril_height",
                    "gene_bs_nose_nostril_width",
                    "gene_bs_nose_profile",
                    "gene_bs_nose_ridge_angle",
                    "gene_bs_nose_ridge_width",
                    "gene_bs_nose_size",
                    "gene_bs_nose_tip_angle",
                    "gene_bs_nose_tip_forward",
                    "gene_bs_nose_tip_width",
                    "face_detail_cheek_def",
                    "face_detail_cheek_fat",
                    "face_detail_chin_cleft",
                    "face_detail_chin_def",
                    "face_detail_eye_lower_lid_def",
                    "face_detail_eye_socket",
                    "face_detail_nasolabial",
                    "face_detail_nose_ridge_def",
                    "face_detail_nose_tip_def",
                    "face_detail_temple_def",
                    "expression_brow_wrinkles",
                    "expression_eye_wrinkles",
                    "expression_forehead_wrinkles",
                    "expression_other",
                    "complexion",
                    "gene_height",
                    "gene_bs_body_type",
                    "gene_bs_body_shape",
                    "gene_bs_bust",
                    "gene_age",
                    "gene_eyebrows_shape",
                    "gene_eyebrows_fullness",
                    "gene_body_hair",
                    "gene_hair_type",
                    "gene_baldness",
                    "eye_accessory",
                    "teeth_accessory",
                    "eyelashes_accessory",
                    "beards",
                    "hairstyles"
            };

    public static LinkedHashMap<String, int[]> Get_Minimum_Dna_Values() {
        LinkedHashMap<String, int[]> minimum_dna_values = new LinkedHashMap<>();
        minimum_dna_values.put("hair_color", new int[]{0, 0, 0, 0});
        minimum_dna_values.put("skin_color", new int[]{0, 0, 0, 0});
        minimum_dna_values.put("eye_color", new int[]{0, 0, 0, 0});
        minimum_dna_values.put("gene_chin_forward", new int[]{0,0,0,115});
        minimum_dna_values.put("gene_chin_height", new int[]{1,0,1,138});
        minimum_dna_values.put("gene_chin_width", new int[]{1,0,1,139});
        minimum_dna_values.put("gene_eye_angle", new int[]{1,0,1,140});
        minimum_dna_values.put("gene_eye_depth", new int[]{1,0,1,154});
        minimum_dna_values.put("gene_eye_height", new int[]{1,0,1,133});
        minimum_dna_values.put("gene_eye_distance", new int[]{0,0,0,117});
        minimum_dna_values.put("gene_eye_shut", new int[]{0,0,0,120});
        minimum_dna_values.put("gene_forehead_angle", new int[]{0,0,0,115});
        minimum_dna_values.put("gene_forehead_brow_height", new int[]{0,0,0,113});
        minimum_dna_values.put("gene_forehead_roundness", new int[]{1,0,1,161});
        minimum_dna_values.put("gene_forehead_width", new int[]{1,0,1,136});
        minimum_dna_values.put("gene_forehead_height", new int[]{0,0,0,103});
        minimum_dna_values.put("gene_head_height", new int[]{1,0,1,146});
        minimum_dna_values.put("gene_head_width", new int[]{1,0,1,158});
        minimum_dna_values.put("gene_head_profile", new int[]{0,0,0,102});
        minimum_dna_values.put("gene_head_top_height", new int[]{1,0,1,134});
        minimum_dna_values.put("gene_head_top_width", new int[]{1,0,1,165});
        minimum_dna_values.put("gene_jaw_angle", new int[]{0,0,0,103});
        minimum_dna_values.put("gene_jaw_forward", new int[]{0,0,0,124});
        minimum_dna_values.put("gene_jaw_height", new int[]{1,0,1,131});
        minimum_dna_values.put("gene_jaw_width", new int[]{1,0,1,176});
        minimum_dna_values.put("gene_mouth_corner_depth", new int[]{0,0,0,117});
        minimum_dna_values.put("gene_mouth_corner_height", new int[]{0,0,0,120});
        minimum_dna_values.put("gene_mouth_forward", new int[]{0,0,0,114});
        minimum_dna_values.put("gene_mouth_height", new int[]{1,0,1,128});
        minimum_dna_values.put("gene_mouth_width", new int[]{0,0,0,124});
        minimum_dna_values.put("gene_mouth_upper_lip_size", new int[]{1,0,1,143});
        minimum_dna_values.put("gene_mouth_lower_lip_size", new int[]{1,0,1,219});
        minimum_dna_values.put("gene_mouth_open", new int[]{0,0,0,31});
        minimum_dna_values.put("gene_neck_length", new int[]{0,0,0,103});
        minimum_dna_values.put("gene_neck_width", new int[]{1,0,1,140});
        minimum_dna_values.put("gene_bs_cheek_forward", new int[]{0,255,0,22});
        minimum_dna_values.put("gene_bs_cheek_height", new int[]{0,255,0,37});
        minimum_dna_values.put("gene_bs_cheek_width", new int[]{0,255,0,43});
        minimum_dna_values.put("gene_bs_ear_angle", new int[]{0,255,1,10});
        minimum_dna_values.put("gene_bs_ear_inner_shape", new int[]{0,0,0,122});
        minimum_dna_values.put("gene_bs_ear_bend", new int[]{0,0,0,34});
        minimum_dna_values.put("gene_bs_ear_outward", new int[]{0,255,1,83});
        minimum_dna_values.put("gene_bs_ear_size", new int[]{0,255,1,7});
        minimum_dna_values.put("gene_bs_eye_corner_depth", new int[]{0,255,1,234});
        minimum_dna_values.put("gene_bs_eye_fold_shape", new int[]{0,255,0,181});
        minimum_dna_values.put("gene_bs_eye_size", new int[]{0,255,0,51});
        minimum_dna_values.put("gene_bs_eye_upper_lid_size", new int[]{0,255,1,1});
        minimum_dna_values.put("gene_bs_forehead_brow_curve", new int[]{0,255,0,99});
        minimum_dna_values.put("gene_bs_forehead_brow_forward", new int[]{0,255,1,45});
        minimum_dna_values.put("gene_bs_forehead_brow_inner_height", new int[]{0,255,1,18});
        minimum_dna_values.put("gene_bs_forehead_brow_outer_height", new int[]{0,255,1,5});
        minimum_dna_values.put("gene_bs_forehead_brow_width", new int[]{0,255,0,21});
        minimum_dna_values.put("gene_bs_jaw_def", new int[]{0,255,0,9});
        minimum_dna_values.put("gene_bs_mouth_lower_lip_def", new int[]{0,0,0,44});
        minimum_dna_values.put("gene_bs_mouth_lower_lip_full", new int[]{0,255,0,38});
        minimum_dna_values.put("gene_bs_mouth_lower_lip_pad", new int[]{0,255,1,111});
        minimum_dna_values.put("gene_bs_mouth_lower_lip_width", new int[]{0,255,0,68});
        minimum_dna_values.put("gene_bs_mouth_philtrum_def", new int[]{0,0,0,25});
        minimum_dna_values.put("gene_bs_mouth_philtrum_shape", new int[]{0,255,1,9});
        minimum_dna_values.put("gene_bs_mouth_philtrum_width", new int[]{0,255,1,13});
        minimum_dna_values.put("gene_bs_mouth_upper_lip_def", new int[]{0,0,0,16});
        minimum_dna_values.put("gene_bs_mouth_upper_lip_full", new int[]{0,255,0,172});
        minimum_dna_values.put("gene_bs_mouth_upper_lip_profile", new int[]{0,255,1,75});
        minimum_dna_values.put("gene_bs_mouth_upper_lip_width", new int[]{0,255,0,43});
        minimum_dna_values.put("gene_bs_nose_forward", new int[]{0,255,0,16});
        minimum_dna_values.put("gene_bs_nose_height", new int[]{0,255,1,42});
        minimum_dna_values.put("gene_bs_nose_length", new int[]{0,255,0,11});
        minimum_dna_values.put("gene_bs_nose_nostril_height", new int[]{0,255,1,10});
        minimum_dna_values.put("gene_bs_nose_nostril_width", new int[]{0,255,0,106});
        minimum_dna_values.put("gene_bs_nose_profile", new int[]{0,255,0,1});
        minimum_dna_values.put("gene_bs_nose_ridge_angle", new int[]{0,255,0,34});
        minimum_dna_values.put("gene_bs_nose_ridge_width", new int[]{0,255,1,34});
        minimum_dna_values.put("gene_bs_nose_size", new int[]{0,255,0,18});
        minimum_dna_values.put("gene_bs_nose_tip_angle", new int[]{0,255,0,45});
        minimum_dna_values.put("gene_bs_nose_tip_forward", new int[]{0,255,0,11});
        minimum_dna_values.put("gene_bs_nose_tip_width", new int[]{0,255,0,7});
        minimum_dna_values.put("face_detail_cheek_def", new int[]{0,0,0,25});
        minimum_dna_values.put("face_detail_cheek_fat", new int[]{0,0,3,158});
        minimum_dna_values.put("face_detail_chin_cleft", new int[]{0,0,1,13});
        minimum_dna_values.put("face_detail_chin_def", new int[]{0,0,1,53});
        minimum_dna_values.put("face_detail_eye_lower_lid_def", new int[]{0,0,0,179});
        minimum_dna_values.put("face_detail_eye_socket", new int[]{0,0,1,211});
        minimum_dna_values.put("face_detail_nasolabial", new int[]{0,0,0,180});
        minimum_dna_values.put("face_detail_nose_ridge_def", new int[]{0,0,0,6});
        minimum_dna_values.put("face_detail_nose_tip_def", new int[]{0,0,0,155});
        minimum_dna_values.put("face_detail_temple_def", new int[]{0,0,0,131});
        minimum_dna_values.put("expression_brow_wrinkles", new int[]{0,0,0,101});
        minimum_dna_values.put("expression_eye_wrinkles", new int[]{0,254,0,254});
        minimum_dna_values.put("expression_forehead_wrinkles", new int[]{0,0,2,201});
        minimum_dna_values.put("expression_other", new int[]{2,0,2,0});
        minimum_dna_values.put("complexion", new int[]{0,0,2,191});
        minimum_dna_values.put("gene_height", new int[]{1,0,1,115});
        minimum_dna_values.put("gene_bs_body_type", new int[]{1,7,1,135});
        minimum_dna_values.put("gene_bs_body_shape", new int[]{1,0,8,0});
        minimum_dna_values.put("gene_bs_bust", new int[]{0,0,7,191});
        minimum_dna_values.put("gene_age", new int[]{0,0,2,44});
        minimum_dna_values.put("gene_eyebrows_shape", new int[]{0,0,3,255});
        minimum_dna_values.put("gene_eyebrows_fullness", new int[]{0,0,1,225});
        minimum_dna_values.put("gene_body_hair", new int[]{0,0,0,209});
        minimum_dna_values.put("gene_hair_type", new int[]{1,95,1,95});
        minimum_dna_values.put("gene_baldness", new int[]{0,127,0,127});
        minimum_dna_values.put("eye_accessory", new int[]{0,159,0,159});
        minimum_dna_values.put("teeth_accessory", new int[]{0,0,0,0});
        minimum_dna_values.put("eyelashes_accessory", new int[]{1,225,1,225});
//        minimum_dna_values.put("no_hairstyles", new int[]{0,0,0,0});
//        minimum_dna_values.put("no_beard", new int[]{0,225,0,0});
        return minimum_dna_values;
    }

    public static LinkedHashMap<String, int[]> Get_Maximum_Dna_Values() {
        LinkedHashMap<String, int[]> maximum_dna_values = new LinkedHashMap<>();
        maximum_dna_values.put("hair_color", new int[]{255, 255, 255, 255});
        maximum_dna_values.put("skin_color", new int[]{255, 255, 255, 255});
        maximum_dna_values.put("eye_color", new int[]{255, 255, 255, 255});
        maximum_dna_values.put("gene_chin_forward", new int[]{0, 255, 0, 115});
        maximum_dna_values.put("gene_chin_height", new int[]{1, 255, 1, 138});
        maximum_dna_values.put("gene_chin_width", new int[]{1, 255, 1, 139});
        maximum_dna_values.put("gene_eye_angle", new int[]{1, 255, 1, 140});
        maximum_dna_values.put("gene_eye_depth", new int[]{1, 255, 1, 154});
        maximum_dna_values.put("gene_eye_height", new int[]{1, 255, 1, 133});
        maximum_dna_values.put("gene_eye_distance", new int[]{0, 255, 0, 117});
        maximum_dna_values.put("gene_eye_shut", new int[]{0, 255, 0, 120});
        maximum_dna_values.put("gene_forehead_angle", new int[]{0, 255, 0, 115});
        maximum_dna_values.put("gene_forehead_brow_height", new int[]{0, 255, 0, 113});
        maximum_dna_values.put("gene_forehead_roundness", new int[]{1, 255, 1, 161});
        maximum_dna_values.put("gene_forehead_width", new int[]{1, 255, 1, 136});
        maximum_dna_values.put("gene_forehead_height", new int[]{0, 255, 0, 103});
        maximum_dna_values.put("gene_head_height", new int[]{1, 255, 1, 146});
        maximum_dna_values.put("gene_head_width", new int[]{1, 255, 1, 158});
        maximum_dna_values.put("gene_head_profile", new int[]{0, 255, 0, 102});
        maximum_dna_values.put("gene_head_top_height", new int[]{1, 255, 1, 134});
        maximum_dna_values.put("gene_head_top_width", new int[]{1, 255, 1, 165});
        maximum_dna_values.put("gene_jaw_angle", new int[]{0, 255, 0, 103});
        maximum_dna_values.put("gene_jaw_forward", new int[]{0, 255, 0, 124});
        maximum_dna_values.put("gene_jaw_height", new int[]{1, 255, 1, 131});
        maximum_dna_values.put("gene_jaw_width", new int[]{1, 255, 1, 176});
        maximum_dna_values.put("gene_mouth_corner_depth", new int[]{0, 255, 0, 117});
        maximum_dna_values.put("gene_mouth_corner_height", new int[]{0, 255, 0, 120});
        maximum_dna_values.put("gene_mouth_forward", new int[]{0, 255, 0, 114});
        maximum_dna_values.put("gene_mouth_height", new int[]{1, 255, 1, 128});
        maximum_dna_values.put("gene_mouth_width", new int[]{0, 255, 0, 124});
        maximum_dna_values.put("gene_mouth_upper_lip_size", new int[]{1, 255, 1, 143});
        maximum_dna_values.put("gene_mouth_lower_lip_size", new int[]{1, 255, 1, 219});
        maximum_dna_values.put("gene_mouth_open", new int[]{0, 255, 0, 31});
        maximum_dna_values.put("gene_neck_length", new int[]{0, 255, 0, 103});
        maximum_dna_values.put("gene_neck_width", new int[]{1, 255, 1, 140});
        maximum_dna_values.put("gene_bs_cheek_forward", new int[]{1, 255, 0, 22});
        maximum_dna_values.put("gene_bs_cheek_height", new int[]{1, 255, 0, 37});
        maximum_dna_values.put("gene_bs_cheek_width", new int[]{1, 255, 0, 43});
        maximum_dna_values.put("gene_bs_ear_angle", new int[]{1, 255, 1, 10});
        maximum_dna_values.put("gene_bs_ear_inner_shape", new int[]{0, 255, 0, 122});
        maximum_dna_values.put("gene_bs_ear_bend", new int[]{2, 255, 0, 34});
        maximum_dna_values.put("gene_bs_ear_outward", new int[]{1, 255, 1, 83});
        maximum_dna_values.put("gene_bs_ear_size", new int[]{1, 255, 1, 7});
        maximum_dna_values.put("gene_bs_eye_corner_depth", new int[]{1, 255, 1, 234});
        maximum_dna_values.put("gene_bs_eye_fold_shape", new int[]{1, 255, 0, 181});
        maximum_dna_values.put("gene_bs_eye_size", new int[]{1, 255, 0, 51});
        maximum_dna_values.put("gene_bs_eye_upper_lid_size", new int[]{1, 255, 1, 1});
        maximum_dna_values.put("gene_bs_forehead_brow_curve", new int[]{1, 255, 0, 99});
        maximum_dna_values.put("gene_bs_forehead_brow_forward", new int[]{1, 255, 1, 45});
        maximum_dna_values.put("gene_bs_forehead_brow_inner_height", new int[]{1, 255, 1, 18});
        maximum_dna_values.put("gene_bs_forehead_brow_outer_height", new int[]{1, 255, 1, 5});
        maximum_dna_values.put("gene_bs_forehead_brow_width", new int[]{1, 255, 0, 21});
        maximum_dna_values.put("gene_bs_jaw_def", new int[]{1, 255, 0, 9});
        maximum_dna_values.put("gene_bs_mouth_lower_lip_def", new int[]{0, 255, 0, 44});
        maximum_dna_values.put("gene_bs_mouth_lower_lip_full", new int[]{1, 255, 0, 38});
        maximum_dna_values.put("gene_bs_mouth_lower_lip_pad", new int[]{1, 255, 1, 111});
        maximum_dna_values.put("gene_bs_mouth_lower_lip_width", new int[]{1, 255, 0, 68});
        maximum_dna_values.put("gene_bs_mouth_philtrum_def", new int[]{0, 255, 0, 25});
        maximum_dna_values.put("gene_bs_mouth_philtrum_shape", new int[]{1, 255, 1, 9});
        maximum_dna_values.put("gene_bs_mouth_philtrum_width", new int[]{1, 255, 1, 13});
        maximum_dna_values.put("gene_bs_mouth_upper_lip_def", new int[]{0, 255, 0, 16});
        maximum_dna_values.put("gene_bs_mouth_upper_lip_full", new int[]{1, 255, 0, 172});
        maximum_dna_values.put("gene_bs_mouth_upper_lip_profile", new int[]{1, 255, 1, 75});
        maximum_dna_values.put("gene_bs_mouth_upper_lip_width", new int[]{1, 255, 0, 43});
        maximum_dna_values.put("gene_bs_nose_forward", new int[]{1, 255, 0, 16});
        maximum_dna_values.put("gene_bs_nose_height", new int[]{1, 255, 1, 42});
        maximum_dna_values.put("gene_bs_nose_length", new int[]{1, 255, 0, 11});
        maximum_dna_values.put("gene_bs_nose_nostril_height", new int[]{1, 255, 1, 10});
        maximum_dna_values.put("gene_bs_nose_nostril_width", new int[]{1, 255, 0, 106});
        maximum_dna_values.put("gene_bs_nose_profile", new int[]{3, 255, 0, 1});
        maximum_dna_values.put("gene_bs_nose_ridge_angle", new int[]{1, 255, 0, 34});
        maximum_dna_values.put("gene_bs_nose_ridge_width", new int[]{1, 255, 1, 34});
        maximum_dna_values.put("gene_bs_nose_size", new int[]{1, 255, 0, 18});
        maximum_dna_values.put("gene_bs_nose_tip_angle", new int[]{1, 255, 0, 45});
        maximum_dna_values.put("gene_bs_nose_tip_forward", new int[]{1, 255, 0, 11});
        maximum_dna_values.put("gene_bs_nose_tip_width", new int[]{1, 255, 0, 7});
        maximum_dna_values.put("face_detail_cheek_def", new int[]{1, 255, 0, 25});
        maximum_dna_values.put("face_detail_cheek_fat", new int[]{4, 255, 3, 158});
        maximum_dna_values.put("face_detail_chin_cleft", new int[]{1, 255, 1, 13});
        maximum_dna_values.put("face_detail_chin_def", new int[]{1, 255, 1, 53});
        maximum_dna_values.put("face_detail_eye_lower_lid_def", new int[]{0, 255, 0, 179});
        maximum_dna_values.put("face_detail_eye_socket", new int[]{5, 255, 1, 211});
        maximum_dna_values.put("face_detail_nasolabial", new int[]{3, 255, 0, 180});
        maximum_dna_values.put("face_detail_nose_ridge_def", new int[]{1, 255, 0, 6});
        maximum_dna_values.put("face_detail_nose_tip_def", new int[]{0, 255, 0, 155});
        maximum_dna_values.put("face_detail_temple_def", new int[]{0, 255, 0, 131});
        maximum_dna_values.put("expression_brow_wrinkles", new int[]{3, 255, 0, 101});
        maximum_dna_values.put("expression_eye_wrinkles", new int[]{0, 254, 0, 254});
        maximum_dna_values.put("expression_forehead_wrinkles", new int[]{2, 255, 2, 201});
        maximum_dna_values.put("expression_other", new int[]{2, 255, 2, 0});
        maximum_dna_values.put("complexion", new int[]{6, 255, 2, 191});
        maximum_dna_values.put("gene_height", new int[]{1, 255, 1, 115});
        maximum_dna_values.put("gene_bs_body_type", new int[]{3, 255, 1, 135});
        maximum_dna_values.put("gene_bs_body_shape", new int[]{11, 255, 8, 0});
        maximum_dna_values.put("gene_bs_bust", new int[]{0, 204, 7, 191});
        maximum_dna_values.put("gene_age", new int[]{3, 255, 2, 44});
        maximum_dna_values.put("gene_eyebrows_shape", new int[]{12, 255, 3, 255});
        maximum_dna_values.put("gene_eyebrows_fullness", new int[]{4, 255, 1, 225});
        maximum_dna_values.put("gene_body_hair", new int[]{5, 255, 0, 209});
        maximum_dna_values.put("gene_hair_type", new int[]{1, 95, 1, 95});
        maximum_dna_values.put("gene_baldness", new int[]{0, 127, 0, 127});
        maximum_dna_values.put("eye_accessory", new int[]{0, 159, 0, 159});
        maximum_dna_values.put("teeth_accessory", new int[]{0, 0, 0, 0});
        maximum_dna_values.put("eyelashes_accessory", new int[]{1, 225, 1, 225});
//        maximum_dna_values.put("no_hairstyles", new int[]{0,0,0,0});
//        maximum_dna_values.put("no_beard", new int[]{0,225,0,0});

        return maximum_dna_values;
    }

    public static List<Integer> Flatten_DNA_Map(LinkedHashMap<String, int[]> map){
//        I don't know how to do this, Java boilerplate game is insane. I'm tired of looking at examples. Screw this.
        List<Integer> list = new ArrayList<>();
        List<int[]> list_of_array = new ArrayList<>(map.values());

        for(var array: list_of_array){
            for(var number: array){
                list.add(number);
            }
        }
        return list;
    }


    public static int MINIMUM_BYTE_AS_INT = 0;
    public static int MAXIMUM_BYTE_AS_INT = 255;
    public static float Calculate_Step(float minimum_bounds, float maximum_bounds){
        return (maximum_bounds - minimum_bounds) / (maximum_bounds - minimum_bounds + 1);
    }
    public static float Calculate_Normalized_Float(float original_value, float minimum_bounds, float maximum_bounds){
        int original_minimum = MINIMUM_BYTE_AS_INT;
        int original_maximum = MAXIMUM_BYTE_AS_INT;

        return (minimum_bounds + ((original_value - original_minimum) * (maximum_bounds - minimum_bounds)) / (original_maximum - original_minimum));
    }

    public static byte Quantize_Normalized_Float_By_Steps(float normalized_value_float, float minimum_bounds, float step){
        return (byte) (((normalized_value_float - minimum_bounds)/ step) + minimum_bounds);
    }

    public static byte Quantize(float original_value, float minimum_bounds, float maximum_bounds){
        float step = Calculate_Step(minimum_bounds, maximum_bounds);
        float normalized_value_float = Calculate_Normalized_Float(original_value, minimum_bounds, maximum_bounds);
        return Quantize_Normalized_Float_By_Steps(normalized_value_float, minimum_bounds, step);
    }

    public static byte[] Normalize_Random_DNA(byte[] randomDNA){

//        TODO: Explore same strand dna. Cut input in half and double it
        List<Integer> minimum_values = Flatten_DNA_Map(Get_Minimum_Dna_Values());
        List<Integer> maximum_values = Flatten_DNA_Map(Get_Maximum_Dna_Values());

        byte[] normalizedRandomDNA = Arrays.copyOf(randomDNA, randomDNA.length);

        assert(randomDNA.length >= minimum_values.size() && minimum_values.size() == maximum_values.size());
        

        for(int i=0; i < minimum_values.size() ; i++){
            float original_value = randomDNA[i]  & 0xFF;
            float minimum_bounds = minimum_values.get(i);
            float maximum_bounds = maximum_values.get(i);
            byte normalized_value;

            if(minimum_bounds == maximum_bounds){
                normalized_value = (byte) minimum_bounds;
            }
            else {
                normalized_value = Quantize(original_value, minimum_bounds, maximum_bounds);
            }
            byte normalized_value_byteized = (byte) (normalized_value  & 0xFF);
            normalizedRandomDNA[i] = normalized_value_byteized;
        }

        return normalizedRandomDNA;

    }

    public static String Create_Random_DNA() {
        byte[] b = new byte[416];
//        byte[] b = new byte[424];
        new Random().nextBytes(b);
        byte[] normalizedDNA = Normalize_Random_DNA(b);

        return Base64.getEncoder().encodeToString(normalizedDNA);

//        decrypt_byte_array(normalizedDNA);
//        System.out.println(Arrays.toString(normalizedDNA));

    }

    public static void decrypt_string (String encrypted) {
        byte[] decodedBytes = Base64.getDecoder().decode(encrypted);
        decrypt_byte_array(decodedBytes);
    }

    public static void decrypt_byte_array(byte[] decodedBytes) {
        String designerDNA = HEADER;
        for (int i = 0, j = 0, l = GENES.length, k = decodedBytes.length; i < l && j < k; i++) {
            designerDNA += "		" + GENES[i] + "={ " + (decodedBytes[j++] & 0xFF) + " " + (decodedBytes[j++] & 0xFF) + " " + (decodedBytes[j++] & 0xFF) + " " + (decodedBytes[j++] & 0xFF) + " }\n";
        }
        designerDNA += """
                    }
                    override={
                        portrait_modifier_overrides={
                            custom_hair=no_hair
                            custom_beards=male_empty
                        }
                    }
                """;

        System.out.println(designerDNA);

    }
}



