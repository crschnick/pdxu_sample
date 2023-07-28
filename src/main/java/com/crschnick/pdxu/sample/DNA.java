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

    public static LinkedHashMap<String, int[]> getMinimumDnaValues() {
        LinkedHashMap<String, int[]> minimumDnaValues = new LinkedHashMap<>();
        minimumDnaValues.put("hair_color", new int[]{0, 0, 0, 0});
        minimumDnaValues.put("skin_color", new int[]{0, 0, 0, 0});
        minimumDnaValues.put("eye_color", new int[]{0, 0, 0, 0});
        minimumDnaValues.put("gene_chin_forward", new int[]{0,0,0,115});
        minimumDnaValues.put("gene_chin_height", new int[]{1,0,1,138});
        minimumDnaValues.put("gene_chin_width", new int[]{1,0,1,139});
        minimumDnaValues.put("gene_eye_angle", new int[]{1,0,1,140});
        minimumDnaValues.put("gene_eye_depth", new int[]{1,0,1,154});
        minimumDnaValues.put("gene_eye_height", new int[]{1,0,1,133});
        minimumDnaValues.put("gene_eye_distance", new int[]{0,0,0,117});
        minimumDnaValues.put("gene_eye_shut", new int[]{0,0,0,120});
        minimumDnaValues.put("gene_forehead_angle", new int[]{0,0,0,115});
        minimumDnaValues.put("gene_forehead_brow_height", new int[]{0,0,0,113});
        minimumDnaValues.put("gene_forehead_roundness", new int[]{1,0,1,161});
        minimumDnaValues.put("gene_forehead_width", new int[]{1,0,1,136});
        minimumDnaValues.put("gene_forehead_height", new int[]{0,0,0,103});
        minimumDnaValues.put("gene_head_height", new int[]{1,0,1,146});
        minimumDnaValues.put("gene_head_width", new int[]{1,0,1,158});
        minimumDnaValues.put("gene_head_profile", new int[]{0,0,0,102});
        minimumDnaValues.put("gene_head_top_height", new int[]{1,0,1,134});
        minimumDnaValues.put("gene_head_top_width", new int[]{1,0,1,165});
        minimumDnaValues.put("gene_jaw_angle", new int[]{0,0,0,103});
        minimumDnaValues.put("gene_jaw_forward", new int[]{0,0,0,124});
        minimumDnaValues.put("gene_jaw_height", new int[]{1,0,1,131});
        minimumDnaValues.put("gene_jaw_width", new int[]{1,0,1,176});
        minimumDnaValues.put("gene_mouth_corner_depth", new int[]{0,0,0,117});
        minimumDnaValues.put("gene_mouth_corner_height", new int[]{0,0,0,120});
        minimumDnaValues.put("gene_mouth_forward", new int[]{0,0,0,114});
        minimumDnaValues.put("gene_mouth_height", new int[]{1,0,1,128});
        minimumDnaValues.put("gene_mouth_width", new int[]{0,0,0,124});
        minimumDnaValues.put("gene_mouth_upper_lip_size", new int[]{1,0,1,143});
        minimumDnaValues.put("gene_mouth_lower_lip_size", new int[]{1,0,1,219});
        minimumDnaValues.put("gene_mouth_open", new int[]{0,0,0,31});
        minimumDnaValues.put("gene_neck_length", new int[]{0,0,0,103});
        minimumDnaValues.put("gene_neck_width", new int[]{1,0,1,140});
        minimumDnaValues.put("gene_bs_cheek_forward", new int[]{0,255,0,22});
        minimumDnaValues.put("gene_bs_cheek_height", new int[]{0,255,0,37});
        minimumDnaValues.put("gene_bs_cheek_width", new int[]{0,255,0,43});
        minimumDnaValues.put("gene_bs_ear_angle", new int[]{0,255,1,10});
        minimumDnaValues.put("gene_bs_ear_inner_shape", new int[]{0,0,0,122});
        minimumDnaValues.put("gene_bs_ear_bend", new int[]{0,0,0,34});
        minimumDnaValues.put("gene_bs_ear_outward", new int[]{0,255,1,83});
        minimumDnaValues.put("gene_bs_ear_size", new int[]{0,255,1,7});
        minimumDnaValues.put("gene_bs_eye_corner_depth", new int[]{0,255,1,234});
        minimumDnaValues.put("gene_bs_eye_fold_shape", new int[]{0,255,0,181});
        minimumDnaValues.put("gene_bs_eye_size", new int[]{0,255,0,51});
        minimumDnaValues.put("gene_bs_eye_upper_lid_size", new int[]{0,255,1,1});
        minimumDnaValues.put("gene_bs_forehead_brow_curve", new int[]{0,255,0,99});
        minimumDnaValues.put("gene_bs_forehead_brow_forward", new int[]{0,255,1,45});
        minimumDnaValues.put("gene_bs_forehead_brow_inner_height", new int[]{0,255,1,18});
        minimumDnaValues.put("gene_bs_forehead_brow_outer_height", new int[]{0,255,1,5});
        minimumDnaValues.put("gene_bs_forehead_brow_width", new int[]{0,255,0,21});
        minimumDnaValues.put("gene_bs_jaw_def", new int[]{0,255,0,9});
        minimumDnaValues.put("gene_bs_mouth_lower_lip_def", new int[]{0,0,0,44});
        minimumDnaValues.put("gene_bs_mouth_lower_lip_full", new int[]{0,255,0,38});
        minimumDnaValues.put("gene_bs_mouth_lower_lip_pad", new int[]{0,255,1,111});
        minimumDnaValues.put("gene_bs_mouth_lower_lip_width", new int[]{0,255,0,68});
        minimumDnaValues.put("gene_bs_mouth_philtrum_def", new int[]{0,0,0,25});
        minimumDnaValues.put("gene_bs_mouth_philtrum_shape", new int[]{0,255,1,9});
        minimumDnaValues.put("gene_bs_mouth_philtrum_width", new int[]{0,255,1,13});
        minimumDnaValues.put("gene_bs_mouth_upper_lip_def", new int[]{0,0,0,16});
        minimumDnaValues.put("gene_bs_mouth_upper_lip_full", new int[]{0,255,0,172});
        minimumDnaValues.put("gene_bs_mouth_upper_lip_profile", new int[]{0,255,1,75});
        minimumDnaValues.put("gene_bs_mouth_upper_lip_width", new int[]{0,255,0,43});
        minimumDnaValues.put("gene_bs_nose_forward", new int[]{0,255,0,16});
        minimumDnaValues.put("gene_bs_nose_height", new int[]{0,255,1,42});
        minimumDnaValues.put("gene_bs_nose_length", new int[]{0,255,0,11});
        minimumDnaValues.put("gene_bs_nose_nostril_height", new int[]{0,255,1,10});
        minimumDnaValues.put("gene_bs_nose_nostril_width", new int[]{0,255,0,106});
        minimumDnaValues.put("gene_bs_nose_profile", new int[]{0,255,0,1});
        minimumDnaValues.put("gene_bs_nose_ridge_angle", new int[]{0,255,0,34});
        minimumDnaValues.put("gene_bs_nose_ridge_width", new int[]{0,255,1,34});
        minimumDnaValues.put("gene_bs_nose_size", new int[]{0,255,0,18});
        minimumDnaValues.put("gene_bs_nose_tip_angle", new int[]{0,255,0,45});
        minimumDnaValues.put("gene_bs_nose_tip_forward", new int[]{0,255,0,11});
        minimumDnaValues.put("gene_bs_nose_tip_width", new int[]{0,255,0,7});
        minimumDnaValues.put("face_detail_cheek_def", new int[]{0,0,0,25});
        minimumDnaValues.put("face_detail_cheek_fat", new int[]{0,0,3,158});
        minimumDnaValues.put("face_detail_chin_cleft", new int[]{0,0,1,13});
        minimumDnaValues.put("face_detail_chin_def", new int[]{0,0,1,53});
        minimumDnaValues.put("face_detail_eye_lower_lid_def", new int[]{0,0,0,179});
        minimumDnaValues.put("face_detail_eye_socket", new int[]{0,0,1,211});
        minimumDnaValues.put("face_detail_nasolabial", new int[]{0,0,0,180});
        minimumDnaValues.put("face_detail_nose_ridge_def", new int[]{0,0,0,6});
        minimumDnaValues.put("face_detail_nose_tip_def", new int[]{0,0,0,155});
        minimumDnaValues.put("face_detail_temple_def", new int[]{0,0,0,131});
        minimumDnaValues.put("expression_brow_wrinkles", new int[]{0,0,0,101});
        minimumDnaValues.put("expression_eye_wrinkles", new int[]{0,254,0,254});
        minimumDnaValues.put("expression_forehead_wrinkles", new int[]{0,0,2,201});
        minimumDnaValues.put("expression_other", new int[]{2,0,2,0});
        minimumDnaValues.put("complexion", new int[]{0,0,2,191});
        minimumDnaValues.put("gene_height", new int[]{1,0,1,115});
        minimumDnaValues.put("gene_bs_body_type", new int[]{1,7,1,135});
        minimumDnaValues.put("gene_bs_body_shape", new int[]{1,0,8,0});
        minimumDnaValues.put("gene_bs_bust", new int[]{0,0,7,191});
        minimumDnaValues.put("gene_age", new int[]{0,0,2,44});
        minimumDnaValues.put("gene_eyebrows_shape", new int[]{0,0,3,255});
        minimumDnaValues.put("gene_eyebrows_fullness", new int[]{0,0,1,225});
        minimumDnaValues.put("gene_body_hair", new int[]{0,0,0,209});
        minimumDnaValues.put("gene_hair_type", new int[]{1,95,1,95});
        minimumDnaValues.put("gene_baldness", new int[]{0,127,0,127});
        minimumDnaValues.put("eye_accessory", new int[]{0,159,0,159});
        minimumDnaValues.put("teeth_accessory", new int[]{0,0,0,0});
        minimumDnaValues.put("eyelashes_accessory", new int[]{1,225,1,225});
//        minimum_dna_values.put("no_hairstyles", new int[]{0,0,0,0});
//        minimum_dna_values.put("no_beard", new int[]{0,225,0,0});
        return minimumDnaValues;
    }

    public static LinkedHashMap<String, int[]> getMaximumDnaValues() {
        LinkedHashMap<String, int[]> maximumDnaValues = new LinkedHashMap<>();
        maximumDnaValues.put("hair_color", new int[]{255, 255, 255, 255});
        maximumDnaValues.put("skin_color", new int[]{255, 255, 255, 255});
        maximumDnaValues.put("eye_color", new int[]{255, 255, 255, 255});
        maximumDnaValues.put("gene_chin_forward", new int[]{0, 255, 0, 115});
        maximumDnaValues.put("gene_chin_height", new int[]{1, 255, 1, 138});
        maximumDnaValues.put("gene_chin_width", new int[]{1, 255, 1, 139});
        maximumDnaValues.put("gene_eye_angle", new int[]{1, 255, 1, 140});
        maximumDnaValues.put("gene_eye_depth", new int[]{1, 255, 1, 154});
        maximumDnaValues.put("gene_eye_height", new int[]{1, 255, 1, 133});
        maximumDnaValues.put("gene_eye_distance", new int[]{0, 255, 0, 117});
        maximumDnaValues.put("gene_eye_shut", new int[]{0, 255, 0, 120});
        maximumDnaValues.put("gene_forehead_angle", new int[]{0, 255, 0, 115});
        maximumDnaValues.put("gene_forehead_brow_height", new int[]{0, 255, 0, 113});
        maximumDnaValues.put("gene_forehead_roundness", new int[]{1, 255, 1, 161});
        maximumDnaValues.put("gene_forehead_width", new int[]{1, 255, 1, 136});
        maximumDnaValues.put("gene_forehead_height", new int[]{0, 255, 0, 103});
        maximumDnaValues.put("gene_head_height", new int[]{1, 255, 1, 146});
        maximumDnaValues.put("gene_head_width", new int[]{1, 255, 1, 158});
        maximumDnaValues.put("gene_head_profile", new int[]{0, 255, 0, 102});
        maximumDnaValues.put("gene_head_top_height", new int[]{1, 255, 1, 134});
        maximumDnaValues.put("gene_head_top_width", new int[]{1, 255, 1, 165});
        maximumDnaValues.put("gene_jaw_angle", new int[]{0, 255, 0, 103});
        maximumDnaValues.put("gene_jaw_forward", new int[]{0, 255, 0, 124});
        maximumDnaValues.put("gene_jaw_height", new int[]{1, 255, 1, 131});
        maximumDnaValues.put("gene_jaw_width", new int[]{1, 255, 1, 176});
        maximumDnaValues.put("gene_mouth_corner_depth", new int[]{0, 255, 0, 117});
        maximumDnaValues.put("gene_mouth_corner_height", new int[]{0, 255, 0, 120});
        maximumDnaValues.put("gene_mouth_forward", new int[]{0, 255, 0, 114});
        maximumDnaValues.put("gene_mouth_height", new int[]{1, 255, 1, 128});
        maximumDnaValues.put("gene_mouth_width", new int[]{0, 255, 0, 124});
        maximumDnaValues.put("gene_mouth_upper_lip_size", new int[]{1, 255, 1, 143});
        maximumDnaValues.put("gene_mouth_lower_lip_size", new int[]{1, 255, 1, 219});
        maximumDnaValues.put("gene_mouth_open", new int[]{0, 255, 0, 31});
        maximumDnaValues.put("gene_neck_length", new int[]{0, 255, 0, 103});
        maximumDnaValues.put("gene_neck_width", new int[]{1, 255, 1, 140});
        maximumDnaValues.put("gene_bs_cheek_forward", new int[]{1, 255, 0, 22});
        maximumDnaValues.put("gene_bs_cheek_height", new int[]{1, 255, 0, 37});
        maximumDnaValues.put("gene_bs_cheek_width", new int[]{1, 255, 0, 43});
        maximumDnaValues.put("gene_bs_ear_angle", new int[]{1, 255, 1, 10});
        maximumDnaValues.put("gene_bs_ear_inner_shape", new int[]{0, 255, 0, 122});
        maximumDnaValues.put("gene_bs_ear_bend", new int[]{2, 255, 0, 34});
        maximumDnaValues.put("gene_bs_ear_outward", new int[]{1, 255, 1, 83});
        maximumDnaValues.put("gene_bs_ear_size", new int[]{1, 255, 1, 7});
        maximumDnaValues.put("gene_bs_eye_corner_depth", new int[]{1, 255, 1, 234});
        maximumDnaValues.put("gene_bs_eye_fold_shape", new int[]{1, 255, 0, 181});
        maximumDnaValues.put("gene_bs_eye_size", new int[]{1, 255, 0, 51});
        maximumDnaValues.put("gene_bs_eye_upper_lid_size", new int[]{1, 255, 1, 1});
        maximumDnaValues.put("gene_bs_forehead_brow_curve", new int[]{1, 255, 0, 99});
        maximumDnaValues.put("gene_bs_forehead_brow_forward", new int[]{1, 255, 1, 45});
        maximumDnaValues.put("gene_bs_forehead_brow_inner_height", new int[]{1, 255, 1, 18});
        maximumDnaValues.put("gene_bs_forehead_brow_outer_height", new int[]{1, 255, 1, 5});
        maximumDnaValues.put("gene_bs_forehead_brow_width", new int[]{1, 255, 0, 21});
        maximumDnaValues.put("gene_bs_jaw_def", new int[]{1, 255, 0, 9});
        maximumDnaValues.put("gene_bs_mouth_lower_lip_def", new int[]{0, 255, 0, 44});
        maximumDnaValues.put("gene_bs_mouth_lower_lip_full", new int[]{1, 255, 0, 38});
        maximumDnaValues.put("gene_bs_mouth_lower_lip_pad", new int[]{1, 255, 1, 111});
        maximumDnaValues.put("gene_bs_mouth_lower_lip_width", new int[]{1, 255, 0, 68});
        maximumDnaValues.put("gene_bs_mouth_philtrum_def", new int[]{0, 255, 0, 25});
        maximumDnaValues.put("gene_bs_mouth_philtrum_shape", new int[]{1, 255, 1, 9});
        maximumDnaValues.put("gene_bs_mouth_philtrum_width", new int[]{1, 255, 1, 13});
        maximumDnaValues.put("gene_bs_mouth_upper_lip_def", new int[]{0, 255, 0, 16});
        maximumDnaValues.put("gene_bs_mouth_upper_lip_full", new int[]{1, 255, 0, 172});
        maximumDnaValues.put("gene_bs_mouth_upper_lip_profile", new int[]{1, 255, 1, 75});
        maximumDnaValues.put("gene_bs_mouth_upper_lip_width", new int[]{1, 255, 0, 43});
        maximumDnaValues.put("gene_bs_nose_forward", new int[]{1, 255, 0, 16});
        maximumDnaValues.put("gene_bs_nose_height", new int[]{1, 255, 1, 42});
        maximumDnaValues.put("gene_bs_nose_length", new int[]{1, 255, 0, 11});
        maximumDnaValues.put("gene_bs_nose_nostril_height", new int[]{1, 255, 1, 10});
        maximumDnaValues.put("gene_bs_nose_nostril_width", new int[]{1, 255, 0, 106});
        maximumDnaValues.put("gene_bs_nose_profile", new int[]{3, 255, 0, 1});
        maximumDnaValues.put("gene_bs_nose_ridge_angle", new int[]{1, 255, 0, 34});
        maximumDnaValues.put("gene_bs_nose_ridge_width", new int[]{1, 255, 1, 34});
        maximumDnaValues.put("gene_bs_nose_size", new int[]{1, 255, 0, 18});
        maximumDnaValues.put("gene_bs_nose_tip_angle", new int[]{1, 255, 0, 45});
        maximumDnaValues.put("gene_bs_nose_tip_forward", new int[]{1, 255, 0, 11});
        maximumDnaValues.put("gene_bs_nose_tip_width", new int[]{1, 255, 0, 7});
        maximumDnaValues.put("face_detail_cheek_def", new int[]{1, 255, 0, 25});
        maximumDnaValues.put("face_detail_cheek_fat", new int[]{4, 255, 3, 158});
        maximumDnaValues.put("face_detail_chin_cleft", new int[]{1, 255, 1, 13});
        maximumDnaValues.put("face_detail_chin_def", new int[]{1, 255, 1, 53});
        maximumDnaValues.put("face_detail_eye_lower_lid_def", new int[]{0, 255, 0, 179});
        maximumDnaValues.put("face_detail_eye_socket", new int[]{5, 255, 1, 211});
        maximumDnaValues.put("face_detail_nasolabial", new int[]{3, 255, 0, 180});
        maximumDnaValues.put("face_detail_nose_ridge_def", new int[]{1, 255, 0, 6});
        maximumDnaValues.put("face_detail_nose_tip_def", new int[]{0, 255, 0, 155});
        maximumDnaValues.put("face_detail_temple_def", new int[]{0, 255, 0, 131});
        maximumDnaValues.put("expression_brow_wrinkles", new int[]{3, 255, 0, 101});
        maximumDnaValues.put("expression_eye_wrinkles", new int[]{0, 254, 0, 254});
        maximumDnaValues.put("expression_forehead_wrinkles", new int[]{2, 255, 2, 201});
        maximumDnaValues.put("expression_other", new int[]{2, 255, 2, 0});
        maximumDnaValues.put("complexion", new int[]{6, 255, 2, 191});
        maximumDnaValues.put("gene_height", new int[]{1, 255, 1, 115});
        maximumDnaValues.put("gene_bs_body_type", new int[]{3, 255, 1, 135});
        maximumDnaValues.put("gene_bs_body_shape", new int[]{11, 255, 8, 0});
        maximumDnaValues.put("gene_bs_bust", new int[]{0, 204, 7, 191});
        maximumDnaValues.put("gene_age", new int[]{3, 255, 2, 44});
        maximumDnaValues.put("gene_eyebrows_shape", new int[]{12, 255, 3, 255});
        maximumDnaValues.put("gene_eyebrows_fullness", new int[]{4, 255, 1, 225});
        maximumDnaValues.put("gene_body_hair", new int[]{5, 255, 0, 209});
        maximumDnaValues.put("gene_hair_type", new int[]{1, 95, 1, 95});
        maximumDnaValues.put("gene_baldness", new int[]{0, 127, 0, 127});
        maximumDnaValues.put("eye_accessory", new int[]{0, 159, 0, 159});
        maximumDnaValues.put("teeth_accessory", new int[]{0, 0, 0, 0});
        maximumDnaValues.put("eyelashes_accessory", new int[]{1, 225, 1, 225});
//        maximum_dna_values.put("no_hairstyles", new int[]{0,0,0,0});
//        maximum_dna_values.put("no_beard", new int[]{0,225,0,0});

        return maximumDnaValues;
    }

    public static List<Integer> flattenDnaMap(LinkedHashMap<String, int[]> map){
//        I don't know how to do this, Java boilerplate game is insane. I'm tired of looking at examples. Screw this.
        List<Integer> list = new ArrayList<>();
        List<int[]> listOfArray = new ArrayList<>(map.values());

        for(var array: listOfArray){
            for(var number: array){
                list.add(number);
            }
        }
        return list;
    }


    public static int MINIMUM_BYTE_AS_INT = 0;
    public static int MAXIMUM_BYTE_AS_INT = 255;
    public static float calculateStep(float minimumBounds, float maximumBounds){
        return (maximumBounds - minimumBounds) / (maximumBounds - minimumBounds + 1);
    }
    public static float calculateNormalizedFloat(float originalValue, float minimumBounds, float maximumBounds){
        int originalMinimum = MINIMUM_BYTE_AS_INT;
        int originalMaximum = MAXIMUM_BYTE_AS_INT;

        return (minimumBounds + ((originalValue - originalMinimum) * (maximumBounds - minimumBounds)) / (originalMaximum - originalMinimum));
    }

    public static byte quantizeNormalizedFloatBySteps(float normalizedValueFloat, float minimumBounds, float step){
        return (byte) (((normalizedValueFloat - minimumBounds)/ step) + minimumBounds);
    }

    public static byte quantize(float originalValue, float minimumBounds, float maximumBounds){
        float step = calculateStep(minimumBounds, maximumBounds);
        float normalizedValueFloat = calculateNormalizedFloat(originalValue, minimumBounds, maximumBounds);
        return quantizeNormalizedFloatBySteps(normalizedValueFloat, minimumBounds, step);
    }

    public static byte[] normalizeRandomDna(byte[] randomDNA){

//        TODO: Explore same strand dna. Cut input in half and double it
        List<Integer> minimumValues = flattenDnaMap(getMinimumDnaValues());
        List<Integer> maximumValues = flattenDnaMap(getMaximumDnaValues());

        byte[] normalizedRandomDNA = Arrays.copyOf(randomDNA, randomDNA.length);

        assert(randomDNA.length >= minimumValues.size() && minimumValues.size() == maximumValues.size());
        

        for(int i=0; i < minimumValues.size() ; i++){
            float originalValue = randomDNA[i]  & 0xFF;
            float minimumBounds = minimumValues.get(i);
            float maximumBounds = maximumValues.get(i);
            byte normalizedValue;

            if(minimumBounds == maximumBounds){
                normalizedValue = (byte) minimumBounds;
            }
            else {
                normalizedValue = quantize(originalValue, minimumBounds, maximumBounds);
            }
            byte normalizedValueByteized = (byte) (normalizedValue  & 0xFF);
            normalizedRandomDNA[i] = normalizedValueByteized;
        }

        return normalizedRandomDNA;

    }

    public static String CreateRandomDNA() {
        byte[] b = new byte[416];
        new Random().nextBytes(b);
        byte[] normalizedDNA = normalizeRandomDna(b);

        return Base64.getEncoder().encodeToString(normalizedDNA);

//        decrypt_byte_array(normalizedDNA);
//        System.out.println(Arrays.toString(normalizedDNA));

    }

    public static void decryptString(String encrypted) {
        byte[] decodedBytes = Base64.getDecoder().decode(encrypted);
        decryptByteArray(decodedBytes);
    }

    public static void decryptByteArray(byte[] decodedBytes) {
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



